/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.decorator;

import creational.factory.shape.ShapeInterface;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class RedShapeDecorator extends AbstractDecorator {

    public RedShapeDecorator(ShapeInterface decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public String draw() {
        String shapeStr = this.shape.draw();
        String border = setRedBorder(this.shape);
        return shapeStr + border;
    }

    private String setRedBorder(ShapeInterface shape) {
        return "边框色: Red";
    }

}
