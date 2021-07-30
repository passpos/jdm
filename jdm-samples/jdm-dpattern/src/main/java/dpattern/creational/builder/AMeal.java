/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpattern.creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class AMeal {
    private List<ItemInterface> items = new ArrayList<>();

    public void addItem(ItemInterface item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (ItemInterface item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (ItemInterface item : items) {
            System.out.print("餐项 : " + item.name());
            System.out.print(", 包装方式 : " + item.packing().pack());
            System.out.println(", 价格 : " + item.price());
        }
    }
}
