/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.mybatis.dao;

import jdm.mybatis.entity.Role;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public interface RoleDao {

    public Role findUsers(int id);
}
