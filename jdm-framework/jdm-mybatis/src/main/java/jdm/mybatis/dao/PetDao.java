/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.mybatis.dao;

import jdm.mybatis.entity.Pet;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public interface PetDao {

    public Pet findById(int id);

    public Pet findByIdLazy(int id);
}
