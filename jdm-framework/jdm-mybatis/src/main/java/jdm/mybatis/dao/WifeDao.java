/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.mybatis.dao;

import jdm.mybatis.entity.Wife;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public interface WifeDao {

    public int save(Wife wife);

    public int update(Wife wife);

    public int delete(Wife wife);

    public int deleteById(int id);

    public Wife findById(int id);

    public Wife findWithHusband(int id);
}
