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
public class CircleShape extends AbstractShape {

    private int x, y, radius;

    public CircleShape(int x, int y, int radius, DrawInterface drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
