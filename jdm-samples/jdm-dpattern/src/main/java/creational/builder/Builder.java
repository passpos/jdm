/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.builder;

import creational.builder.burger.ChickenBurgerItem;
import creational.builder.burger.VegBurgerItem;
import creational.builder.drink.CokeDrink;
import creational.builder.drink.PepsiDrink;

/**
 * 建造者模式
 *
 * 建造者模式（Builder Pattern）使用多个简单的对象一步一步构建成一个复杂的对象。
 * 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 *
 * 一个 Builder 类会一步一步构造最终的对象。该 Builder 类是独立于其他对象的。
 *
 * a.意图：
 * 将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。
 *
 * b.主要解决：
 * 主要解决在软件系统中，有时候面临着"一个复杂对象"的创建工作，其通常由各个部分的子对象用一定的算法
 * 构成；由于需求的变化，这个复杂对象的各个部分经常面临着剧烈的变化，但是将它们组合在一起的算法却相
 * 对稳定。
 *
 * c.何时使用：
 * 一些基本部件不会变，而其组合经常变化的时候。
 *
 * d.如何解决：
 * 将变与不变分离开。
 *
 * e.关键代码：
 * 建造者：创建和提供实例，导演：管理建造出来的实例的依赖关系。
 *
 * f.应用实例：
 * 1.去肯德基，汉堡、可乐、薯条、炸鸡翅等是不变的，而其组合是经常变化的，生成出所谓的"套餐"。
 * 2.JAVA 中的 StringBuilder。
 *
 * g.优点：
 * 1.建造者独立，易扩展。
 * 2.便于控制细节风险。
 *
 * h.缺点：
 * 1.产品必须有共同点，范围有限制。
 * 2.如内部变化复杂，会有很多的建造类。
 *
 * i.使用场景：
 * 1.需要生成的对象具有复杂的内部结构。
 * 2.需要生成的对象内部属性本身相互依赖。
 *
 * j.注意事项：
 * 与工厂模式的区别是：建造者模式更加关注于零件装配的顺序。
 *
 * @author passpos <paiap@outlook.com>
 */
public class Builder {

    // 该方法一般存放在应用类中
    public static void useBuilder() {
        Builder builder = new Builder();

        AMeal vegMeal = builder.prepareVegMeal();
        System.out.println("素餐");
        vegMeal.showItems();
        System.out.println("总金额：" + vegMeal.getCost());

        AMeal nonVegMeal = builder.prepareNonVegMeal();
        System.out.println("\n\n非素");
        nonVegMeal.showItems();
        System.out.println("总金额：" + nonVegMeal.getCost());
    }

    public AMeal prepareVegMeal() {
        AMeal meal = new AMeal();
        meal.addItem(new VegBurgerItem());
        meal.addItem(new CokeDrink());
        return meal;
    }

    public AMeal prepareNonVegMeal() {
        AMeal meal = new AMeal();
        meal.addItem(new ChickenBurgerItem());
        meal.addItem(new PepsiDrink());
        return meal;
    }

    public static void main(String[] args) {
        useBuilder();
    }
}
