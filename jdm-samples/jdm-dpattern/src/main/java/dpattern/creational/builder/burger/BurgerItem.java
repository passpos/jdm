/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpattern.creational.builder.burger;

import dpattern.creational.builder.ItemInterface;
import dpattern.creational.builder.PackingInterface;
import dpattern.creational.builder.packing.WrapperPacking;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public abstract class BurgerItem implements ItemInterface {

    @Override
    public PackingInterface packing() {
        return new WrapperPacking();
    }

    @Override
    public abstract float price();
}
