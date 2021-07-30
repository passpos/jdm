/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creational.builder.burger;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class VegBurgerItem extends BurgerItem {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "蔬菜汉堡";
    }

}
