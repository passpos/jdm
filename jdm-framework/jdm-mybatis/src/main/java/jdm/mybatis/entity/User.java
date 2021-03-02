/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.mybatis.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class User {

    private int id;
    private String userName;
    private int age;
    private Set<Role> myRoles = new HashSet<>();
    private Set<Pet> myPets = new HashSet<>();

    public User() {
    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Role> getMyRoles() {
        return myRoles;
    }

    public void setMyRoles(Set<Role> myRoles) {
        this.myRoles = myRoles;
    }

    public Set<Pet> getMyPets() {
        return myPets;
    }

    public void setMyPets(Set<Pet> myPets) {
        this.myPets = myPets;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.getId()) {
            return false;
        }
        if (this.age != other.getAge()) {
            return false;
        }
        return Objects.equals(this.userName, other.getUserName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.userName);
        hash = 59 * hash + this.age;
        return hash;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", age=" + age + ", myPets=" + myPets + ", myRoles=" + myRoles + '}';
    }

}
