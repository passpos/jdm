/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creational.builder.drink;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class PepsiDrink extends ColdDrinkItem {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "百事可乐";
    }

}
