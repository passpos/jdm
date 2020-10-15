/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.mybatis.entity;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class Pet {

    private Integer id;
    private String petName;
    private User master;

    public Pet() {
    }

    public Pet(String petName) {
        this.petName = petName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public User getMaster() {
        return master;
    }

    public void setMaster(User master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "Pet{" + "id=" + id + ", petName=" + petName + ", master=" + master + '}';
    }

}
