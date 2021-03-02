/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.mybatis.entity;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class Role {

    private Integer id;
    private String roleName;
    private Set<User> userGroup = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(Set<User> userGroup) {
        this.userGroup = userGroup;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", roleName=" + roleName + ", userGroup=" + userGroup + '}';
    }

}
