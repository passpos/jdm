/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creational.factory.shape;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class RectangleShape implements ShapeInterface {

    @Override
    public String draw() {
        return "rectangle";
    }

}
