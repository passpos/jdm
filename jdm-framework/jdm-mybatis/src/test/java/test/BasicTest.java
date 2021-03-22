/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.InputStream;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import test.basic.UserDaoTest;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public abstract class BasicTest {
    
    private SqlSession sqlSession;
    
    public BasicTest() {
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
        }
        init();
    }
    
    public abstract void init();
    
    public void commit() {
        sqlSession.commit();
    }
    
    @AfterAll
    public void close() {
        // 关闭连接
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
    
    public final <T> void ol(T arg) {
        System.out.println(arg);
    }
    
    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public <T> T getDao(Class<T> type) {
        T mapper = sqlSession.getMapper(type);
        return mapper;
    }
}
