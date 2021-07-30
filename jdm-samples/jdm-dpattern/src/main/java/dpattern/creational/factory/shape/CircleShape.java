/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpattern.creational.factory.shape;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class CircleShape implements ShapeInterface {

    @Override
    public String draw() {
        return "circle";
    }

}
