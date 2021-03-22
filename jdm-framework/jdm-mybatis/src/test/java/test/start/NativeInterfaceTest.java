/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.start;

import jdm.mybatis.entity.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import test.BasicTest;

/**
 * 原生接口
 *
 * 指直接使用由用户提供的SQL语句，并通过 SqlSession 进行增、删、改、查的操作；
 * 这种方式将SQL语句直接嵌套进入代码中，排错困难。由于SQL语句被写死了，所以十分
 * 不灵活，
 *
 * @author passpos <paiap@outlook.com>
 */
public class NativeInterfaceTest extends BasicTest {

    @Override
    public void init() {

    }

    @Disabled
    public void addUser() {
        String statement = "jdm.mybatis.repository.UserMapper.save";
        User user = new User("second", 20);
        getSqlSession().insert(statement, user);
        commit();
    }

    @Test
    public void testFindByAge() {
        String statement = "jdm.mybatis.repository.UserMapper.findByAge";
        Integer age = 18;
        User user = getSqlSession().selectOne(statement, age);
        ol(user);
    }
}
