/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structural.bridge;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class GreenCircle implements DrawInterface {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("画圆[ 颜色: 绿色, 半径: "
                + radius + ", x: " + x + ", " + y + "]");
    }

}
