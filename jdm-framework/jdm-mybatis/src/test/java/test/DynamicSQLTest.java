/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import jdm.mybatis.dao.UserDao;
import jdm.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;

/**
 * 动态SQL
 *
 * @author passpos <paiap@outlook.com>
 */
public class DynamicSQLTest {

    private SqlSession sqlSession;
    private UserDao urp;

    public DynamicSQLTest() {
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
            return;
        }

        urp = sqlSession.getMapper(UserDao.class);

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

    public void dynamicSql() {
        ArrayList<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        ids.add(4L);
        ids.add(9L);
        List<User> users = urp.findSomUsersById(ids);
        for (User user : users) {
            ol(user);
        }
    }
}
