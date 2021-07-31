/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.flyweight;

import creational.factory.shape.ShapeInterface;
import java.util.HashMap;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class ShapeFactory {

    private static final HashMap<String, ShapeInterface> circleMap = new HashMap<>();

    // 依据颜色，从map中取出实例
    public static ShapeInterface getCircle(String color) {
        FullCircleShape circle = (FullCircleShape) circleMap.get(color);

        // 如果没有就进行创建，并放入map
        if (circle == null) {
            circle = new FullCircleShape(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
