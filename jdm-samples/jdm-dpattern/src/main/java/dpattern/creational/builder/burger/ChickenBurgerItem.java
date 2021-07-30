/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpattern.creational.builder.burger;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class ChickenBurgerItem extends BurgerItem {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "鸡肉汉堡";
    }

}
