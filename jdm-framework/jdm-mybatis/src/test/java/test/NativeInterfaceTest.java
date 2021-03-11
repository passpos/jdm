/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.InputStream;
import jdm.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * 原生接口
 *
 * @author passpos <paiap@outlook.com>
 */
public class NativeInterfaceTest {

    private SqlSession sqlSession;

    public NativeInterfaceTest() {
        init();
    }

    private void init() {
        // 加载MyBatis配置文件
        InputStream istream = UserDaoTest.class.getClassLoader().getResourceAsStream("mybatis/config.xml");
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
        }

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

    @Disabled
    public void addUser() {
        String statement = "jdm.mybatis.repository.UserMapper.save";
        User user = new User("second", 20);
        sqlSession.insert(statement, user);
        sqlSession.commit();
    }

    @Test
    public void testFindByAge() {
        String statement = "jdm.mybatis.repository.UserMapper.findByAge";
        Integer age = 18;
        User user = sqlSession.selectOne(statement, age);
        ol(user);
    }
}
