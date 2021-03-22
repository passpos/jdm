/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.basic;

import jdm.mybatis.dao.PetDao;
import jdm.mybatis.dao.RoleDao;
import jdm.mybatis.dao.UserDao;
import jdm.mybatis.dao.WifeDao;
import jdm.mybatis.entity.Pet;
import jdm.mybatis.entity.Role;
import jdm.mybatis.entity.User;
import jdm.mybatis.entity.Wife;
import org.junit.jupiter.api.Test;
import test.BasicTest;

/**
 * 级联操作
 *
 * @author passpos <paiap@outlook.com>
 */
public class CascadeOperatorTest extends BasicTest {

    private UserDao urp;
    private PetDao prp;
    private RoleDao rrp;
    private WifeDao wrp;

    @Override
    public void init() {
        urp = getDao(UserDao.class);
        prp = getDao(PetDao.class);
        rrp = getDao(RoleDao.class);
        wrp = getDao(WifeDao.class);
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

    @Test
    public void testFindPets() {
        User user = urp.findPets(4);
        for (Pet pet : user.getMyPets()) {
            ol(pet);
        }
    }

    @Test
    public void testFindRoles() {
        User user = urp.findRoles(9);
        for (Role myRole : user.getMyRoles()) {
            ol(myRole);
        }
        ol(user);
    }

    public void findUsers() {
        Role role = rrp.findUsers(2);
        ol(role);
    }
}
