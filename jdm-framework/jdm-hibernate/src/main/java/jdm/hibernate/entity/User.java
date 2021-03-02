/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class User {

    private Integer id;
    private String userName;
    private Set<Pet> myPets = new HashSet<>();
    private Set<Role> myRoles = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Pet> getMyPets() {
        return myPets;
    }

    public void setMyPets(Set<Pet> myPets) {
        this.myPets = myPets;
    }

    public Set<Role> getMyRoles() {
        return myRoles;
    }

    public void setMyRoles(Set<Role> myRoles) {
        this.myRoles = myRoles;
    }

}
