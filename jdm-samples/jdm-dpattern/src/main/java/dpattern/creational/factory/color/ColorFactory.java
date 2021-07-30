/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpattern.creational.factory.color;

import dpattern.creational.factory.AbstractFactory;
import dpattern.creational.factory.shape.ShapeInterface;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public ShapeInterface getShape(String shapeType) {
        return null;
    }

    @Override
    public ColorInterface getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new RedColor();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new GreenColor();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new BlueColor();
        }
        return null;
    }

}
