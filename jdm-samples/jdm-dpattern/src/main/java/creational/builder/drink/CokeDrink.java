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
public class CokeDrink extends ColdDrinkItem {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "可口可乐";
    }

}
