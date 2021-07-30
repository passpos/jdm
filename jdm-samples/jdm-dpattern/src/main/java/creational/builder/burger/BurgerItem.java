/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.builder.burger;

import creational.builder.ItemInterface;
import creational.builder.PackingInterface;
import creational.builder.packing.WrapperPacking;

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
