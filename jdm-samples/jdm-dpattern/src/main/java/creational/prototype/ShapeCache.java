/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.prototype;

import java.util.HashMap;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class ShapeCache {

    private static HashMap<String, AbstractShape> map = new HashMap<>();

    /* 核心之处
     * 通过克隆快速获取新对象；
     *
     * 在数据库情形中。
     */
    public static AbstractShape getShape(String shapeId) {
        AbstractShape shape = map.get(shapeId);
        return (AbstractShape) shape.clone();
    }

    // 对每种形状都运行数据库查询，并创建该形状。然后放入缓存集中。
    public static void loadCache() {
        CircleShape circle = new CircleShape();
        circle.setId("1");
        map.put(circle.getId(), circle);

        SquareShape square = new SquareShape();
        square.setId("2");
        map.put(square.getId(), square);

        RectangleShape rectangle = new RectangleShape();
        rectangle.setId("3");
        map.put(rectangle.getId(), rectangle);
    }
}
