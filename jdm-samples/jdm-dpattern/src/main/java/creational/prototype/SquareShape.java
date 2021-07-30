/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creational.prototype;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class SquareShape extends AbstractShape {

    public SquareShape() {
        type = "正方形";
    }

    @Override
    void draw() {
        System.out.println("画一个正方形");
    }

}
