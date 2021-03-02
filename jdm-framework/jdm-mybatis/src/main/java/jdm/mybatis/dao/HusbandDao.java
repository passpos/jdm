/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.mybatis.dao;

import jdm.mybatis.entity.Husband;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public interface HusbandDao {

    public int save(Husband husband);

    public int update(Husband husband);

    public int delete(Husband husband);

    public int deleteById(int id);

    public Husband findByHusband(Husband husband);

    public Husband findById(int id);

    public Husband findByWifeId(int id);

}
