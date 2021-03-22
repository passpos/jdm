/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.basic;

import java.util.List;
import jdm.mybatis.dao.PetDao;
import jdm.mybatis.dao.UserDao;
import jdm.mybatis.entity.Pet;
import jdm.mybatis.entity.User;
import org.junit.jupiter.api.Test;
import test.BasicTest;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class UserDaoTest extends BasicTest {

    private UserDao urp;
    private PetDao prp;

    @Override
    public void init() {
        urp = getSqlSession().getMapper(UserDao.class);
        prp = getSqlSession().getMapper(PetDao.class);
    }

    /* -------------------------------------------------------------------------
     * 映射代理
     *
     * 当数据会发生变化时，需要提交事务，才能持久化；
     * ---------------------------------------------------------------------- */
    public void save() {
        User user = new User("four", 6);
        urp.save(user);
        commit();
    }

    public void update() {
        User user = urp.findById(1);
        if (user != null) {
            user.setUserName("老猫");
            urp.update(user);
            commit();
        }
    }

    public void deleteByAge() {
        int deleteCount = urp.deleteByAge(6);
        commit();
        ol(deleteCount);
    }

    @Test
    public void testFindAll() {
        List<User> users = urp.findAll();
        ol(users);
        for (User user : users) {
            ol(user);
            ol(user.getClass());
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

}
