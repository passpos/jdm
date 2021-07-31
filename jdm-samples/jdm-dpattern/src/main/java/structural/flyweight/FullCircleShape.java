/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.flyweight;

import creational.factory.shape.ShapeInterface;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class FullCircleShape implements ShapeInterface {

    private String color;
    private int x;
    private int y;
    private int radius;

    public FullCircleShape(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String draw() {
        return "Circle: Draw() [Color : " + color
                + ", x : " + x
                + ", y :" + y
                + ", radius :" + radius;
    }

}
