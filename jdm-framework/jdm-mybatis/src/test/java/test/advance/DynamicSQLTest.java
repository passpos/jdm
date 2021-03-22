/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.advance;

import java.util.ArrayList;
import java.util.List;
import jdm.mybatis.dao.UserDao;
import jdm.mybatis.entity.User;
import test.BasicTest;

/**
 * 动态SQL
 *
 * 动态SQL指：MyBatis在Mapper.xml的SQL中，插入的语法标签。
 *
 * 注：可以在 Mapper.xml 中查看其中的细节；
 *
 * @author passpos <paiap@outlook.com>
 */
public class DynamicSQLTest extends BasicTest {

    private UserDao urp;

    @Override
    public void init() {
        urp = getSqlSession().getMapper(UserDao.class);
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
