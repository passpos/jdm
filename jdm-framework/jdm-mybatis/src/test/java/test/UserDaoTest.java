/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.InputStream;
import java.util.List;
import jdm.mybatis.dao.PetDao;
import jdm.mybatis.dao.RoleDao;
import jdm.mybatis.dao.UserDao;
import jdm.mybatis.dao.WifeDao;
import jdm.mybatis.entity.Pet;
import jdm.mybatis.entity.Role;
import jdm.mybatis.entity.User;
import jdm.mybatis.entity.Wife;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class UserDaoTest {

    private SqlSession sqlSession;
    private UserDao urp;
    private PetDao prp;
    private RoleDao rrp;
    private WifeDao wrp;

    public UserDaoTest() {
        init();
    }

    private void init() {
        // 加载MyBatis配置文件
        InputStream istream = UserDaoTest.class.getClassLoader().getResourceAsStream("config/mybatis.xml");
        if (istream == null) {
            ol("找不到配置文件！");
            return;
        }

        // 建立数据库连接
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory ssf = ssfb.build(istream);
        if (ssf != null) {
            sqlSession = ssf.openSession();
        } else {
            ol("连接数据库失败！");
            return;
        }

        // 执行测试
        if (sqlSession == null) {
            ol("获取SqlSession实例失败！");
            return;
        }

        urp = sqlSession.getMapper(UserDao.class);
        prp = sqlSession.getMapper(PetDao.class);
        rrp = sqlSession.getMapper(RoleDao.class);
        wrp = sqlSession.getMapper(WifeDao.class);

    }

    @AfterAll
    public void close() {
        // 关闭连接
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    public <T> void ol(T arg) {
        System.out.println(arg);
    }

    /* -------------------------------------------------------------------------
     * 映射代理
     *
     * 当数据会发生变化时，需要提交事务，才能持久化；
     * ---------------------------------------------------------------------- */
    public void save() {
        User user = new User("four", 6);
        urp.save(user);
        sqlSession.commit();
    }

    public void update() {
        User user = urp.findById(1);
        if (user != null) {
            user.setUserName("老猫");
            urp.update(user);
            sqlSession.commit();
        }
    }

    public void deleteByAge() {
        int deleteCount = urp.deleteByAge(6);
        sqlSession.commit();
        ol(deleteCount);
    }

    public void findAll() {
        List<User> users = urp.findAll();
        ol(users);
        for (User user : users) {
            ol(user);
        }
    }

    public void findUserById() {
        User user = urp.findById(1);
        ol(user);
    }

    public void finPetById() {
        Pet pet = prp.findById(1);
        ol(pet);
    }

    public void findByName() {
        User user = urp.findByName("second");
        ol(user);
    }

    public void findByNameAndAge() {
        User user = urp.findByNameAndAge("first", 18);
        ol(user);
    }

    public void count() {
        int count = urp.count();
        ol(count);
    }

    /* -------------------------------------------------------------------------
     * 级联操作
     * MyBatis并不支持真正意义上的级联操作，但这并不意味着它做不到；
     * MyBatis的着眼点是一条SQL语句，以及执行后的结果集；
     * 把Dao接口的多个方法组合起来，就能轻松灵活的实现这些目标。
     * ---------------------------------------------------------------------- */
    // 一对一
    public void findWifeWithHusband() {
        Wife wife = wrp.findWithHusband(1);
        ol(wife);
    }

    public void findPetById() {
        Pet pet = prp.findById(1);
        ol(pet);
    }

    public void findPets() {
        User user = urp.findPets(4);
        ol(user);
    }

    @Test
    public void testFindRoles() {
        User user = urp.findRoles(9);
        for (Role myRole : user.getMyRoles()) {
            ol(myRole.getClass());
        }
        ol(user);
    }

    public void findUsers() {
        Role role = rrp.findUsers(2);
        ol(role);
    }

}
