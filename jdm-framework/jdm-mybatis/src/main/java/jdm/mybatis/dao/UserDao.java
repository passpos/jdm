/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.mybatis.dao;

import java.util.List;
import jdm.mybatis.entity.User;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public interface UserDao {

    public int save(User user);

    public int update(User user);

    public int delete(User user);

    public int deleteById(int id);

    public int deleteByAge(int age);

    public int count();

    public List<User> findAll();

    public User findById(int id);

    public User findByIdLazy(int id);

    public User findByUser(User user);

    public User findByName(String userName);

    public User findByNameAndAge(String userName, int age);

    public User findRoles(int id);

    public User findPets(int id);

    public List<User> findSomUsersById(List<Long> ids);
}
