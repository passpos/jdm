/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpattern.creational.builder.drink;

import dpattern.creational.builder.ItemInterface;
import dpattern.creational.builder.PackingInterface;
import dpattern.creational.builder.packing.BottlePacking;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public abstract class ColdDrinkItem implements ItemInterface {

    @Override
    public PackingInterface packing() {
        return new BottlePacking();
    }

    @Override
    public abstract float price();

}
