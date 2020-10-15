/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.mybatis.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdm.mybatis.dao.PetRepository;
import jdm.mybatis.dao.RoleRepository;
import jdm.mybatis.dao.UserRepository;
import jdm.mybatis.entity.Pet;
import jdm.mybatis.entity.Role;
import jdm.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class Test {

    private static SqlSession sqlSession;
    private static UserRepository urp;
    private static PetRepository prp;
    private static RoleRepository rrp;
    
    public static void main(String[] args) {
        // 加载MyBatis配置文件
        InputStream istream = Test.class.getClassLoader().getResourceAsStream("mybatis/config.xml");
        if (istream == null) {
            System.out.println("找不到配置文件！");
            return;
        }

        // 建立数据库连接
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory ssf = ssfb.build(istream);
        if (ssf != null) {
            sqlSession = ssf.openSession();
        } else {
            System.out.println("连接数据库失败！");
            return;
        }

        // 执行测试
        if (sqlSession != null) {
            index();

            // 关闭连接
            sqlSession.close();
        } else {
            System.out.println("获取SqlSession实例失败！");
        }
    }

    public static void index() {
        // nativeInterface();

        urp = sqlSession.getMapper(UserRepository.class);
        prp = sqlSession.getMapper(PetRepository.class);
        rrp = sqlSession.getMapper(RoleRepository.class);

        // mapProxy();
        associationOperator();
        // generator();
    }

    /**
     * 原生接口
     */
    public static void nativeInterface() {
//        addUser();
        findByAge();
    }
    
    public static void addUser() {
        String statement = "jdm.mybatis.repository.UserMapper.save";
        User user = new User("second", 20);
        sqlSession.insert(statement, user);
        sqlSession.commit();
    }
    
    public static void findByAge() {
        String statement = "jdm.mybatis.repository.UserMapper.findByAge";
        Integer age = 18;
        User user = sqlSession.selectOne(statement, age);
        System.out.println(user);
    }

    /**
     * 映射代理
     *
     * 当数据会发生变化时，需要提交事务，才能持久化；
     */
    public static void mapProxy() {
//        save();
        update();
//        deleteByAge();
        findAll();
        findUserById();
        finPetById();
        findByName();
        findByNameAndAge();
        count();
    }
    
    public static void save() {
        User user = new User("four", 6);
        urp.save(user);
        sqlSession.commit();
    }
    
    public static void update() {
        User user = urp.findById(1);
        if (user != null) {
            user.setUserName("老猫");
            urp.update(user);
            sqlSession.commit();
        }
    }
    
    public static void deleteByAge() {
        int deleteCount = urp.deleteByAge(6);
        sqlSession.commit();
        System.out.println(deleteCount);
    }
    
    public static void findAll() {
        List<User> users = urp.findAll();
        System.out.println(users);
        for (User user : users) {
            System.out.println(user);
        }
    }
    
    public static void findUserById() {
        User user = urp.findById(1);
        System.out.println(user);
    }
    
    public static void finPetById() {
        Pet pet = prp.findById(1);
        System.out.println(pet);
    }
    
    public static void findByName() {
        User user = urp.findByName("second");
        System.out.println(user);
    }
    
    public static void findByNameAndAge() {
        User user = urp.findByNameAndAge("first", 18);
        System.out.println(user);
    }
    
    public static void count() {
        int count = urp.count();
        System.out.println(count);
    }

    /**
     * 级联操作
     * MyBatis并不支持真正意义上的级联操作，但这并不意味着它做不到；
     * MyBatis的着眼点是一条SQL语句，以及执行后的结果集；
     * 把Dao接口的多个方法组合起来，就能轻松灵活的实现这些目标。
     */
    public static void associationOperator() {
        findPetById();
        findPets();
        findRoles();
        findUsers();
    }
    
    public static void findPetById() {
        Pet pet = prp.findById(1);
        System.out.println(pet);
    }
    
    public static void findPets() {
        User user = urp.findPets(4);
        System.out.println(user);
    }
    
    public static void findRoles() {
        User user = urp.findRoles(4);
        System.out.println(user);
    }
    
    public static void findUsers() {
        Role role = rrp.findUsers(2);
        System.out.println(role);
    }

    /**
     * 逆向工程
     */
    public static void generator() {
        // 加载配置
        String genConf = "mybatis/generatorConfig.xml";
        File conf = new File(Test.class.getClassLoader().getResource(genConf).getFile());
        
        ArrayList<String> warnings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warnings);

        // 解析配置
        Configuration config = null;
        try {
            config = cp.parseConfiguration(conf);
        } catch (IOException | XMLParserException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (config == null) {
            return;
        }

        // 为注册对象生成回调；
        boolean overwrite = true;
        DefaultShellCallback dsc = new DefaultShellCallback(overwrite);

        // 生成注册对象
        MyBatisGenerator mbg = null;
        try {
            mbg = new MyBatisGenerator(config, dsc, warnings);
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (mbg == null) {
            return;
        }

        // 执行注册
        try {
            mbg.generate(null);
        } catch (SQLException | IOException | InterruptedException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
