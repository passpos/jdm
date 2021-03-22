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
 * 原生接口指：直接使用 SqlSession 进行增、删、改、查的操作；
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
