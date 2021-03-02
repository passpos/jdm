/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.mybatis.entity;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class Wife {

    private int id;
    private String name;
    private boolean gender;
    private Husband husband;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    @Override
    public String toString() {
        return "Wife{\n\t"
                + "id=" + id
                + ", \n\tname=" + name
                + ", \n\tgender=" + gender
                + ", \n\thusband=" + husband
                + "\n}";
    }

}
