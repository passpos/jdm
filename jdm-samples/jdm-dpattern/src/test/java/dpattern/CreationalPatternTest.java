/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpattern;

import creational.Singleton;
import creational.builder.AMeal;
import creational.builder.Builder;
import creational.factory.AbstractFactory;
import creational.factory.color.ColorFactory;
import creational.factory.color.ColorInterface;
import creational.factory.shape.ShapeFactory;
import creational.factory.shape.ShapeInterface;
import creational.prototype.AbstractShape;
import creational.prototype.ShapeCache;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * 创建型模式
 *
 * 这些设计模式提供了一种在创建对象的同时隐藏创建逻辑的方式，而不是使用 new 运算符直接实例化对象。
 * 这使得程序在判断针对某个给定实例需要创建哪些对象时更加灵活。
 *
 * 单例模式（Singleton Pattern）
 * creational.Singleton
 *
 * 工厂模式（Factory Pattern）
 * creational.factory.shape.ShapeFactory
 * creational.factory.color.ColorFactory
 *
 * 抽象工厂模式（Abstract Factory Pattern）
 * creational.factory.AbstractFactory
 *
 * 建造者模式（Builder Pattern）
 * creational.builder.Builder
 *
 * 原型模式（Prototype Pattern）
 * creational.prototype.AbstractShape
 * creational.prototype.ShapeCache
 *
 * @author passpos <paiap@outlook.com>
 */
public class CreationalPatternTest {

    /* -------------------------------------------------------------------------
     * 创建型
     * ---------------------------------------------------------------------- */
    // 单例模式
    @Test
    public void testSingletonGetInstance() {
        System.out.println("---------------------------------------------------");
        System.out.println("Singleton - getInstance");
        Singleton insrance1 = Singleton.getInstance();
        Singleton insrance2 = Singleton.getInstance();
        assertEquals(insrance1, insrance2);
    }

    // 单例模式（序列化漏洞）
    @Disabled
    @Test
    public void testSingletonSerializableBug() {
        System.out.println("---------------------------------------------------");
        System.out.println("Singletong - SerializableBug");
        Singleton s = Singleton.getInstance();

        //写
        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("学习Java的小姐姐"))) {
            oos.writeObject(s);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PatternTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSerializableException ex) {
            System.out.println("Singleton 未实现序列化接口");
        } catch (IOException ex) {
            Logger.getLogger(PatternTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //读
        Singleton s1 = null;
        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream("学习Java的小姐姐"))) {
            s1 = (Singleton) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PatternTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PatternTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals(s, s1);
    }

    // 工厂模式
    @Test
    public void testFactory() {
        System.out.println("---------------------------------------------------");
        System.out.println("Factory");

        ShapeFactory factory = new ShapeFactory();

        //获取 CircleShape 的对象，并调用它的 draw 方法
        ShapeInterface s1 = factory.getShape("CIRCLE");
        assertEquals("circle", s1.draw());

        //获取 RectangleShape 的对象，并调用它的 draw 方法
        ShapeInterface s2 = factory.getShape("RECTANGLE");
        assertEquals("rectangle", s2.draw());

        //获取 SquareShape 的对象，并调用它的 draw 方法
        ShapeInterface s3 = factory.getShape("SQUARE");
        assertEquals("square", s3.draw());
    }

    // 抽象工厂模式（根据参数，获取特定工厂）
    public AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        } else {
            return null;
        }
    }

    // 抽象工厂模式（根据参数，获取指定实例）
    public String getColorShape(String colorStr, String shapeStr) {
        AbstractFactory colorFactory = getFactory("COLOR");
        AbstractFactory shapeFactory = getFactory("SHAPE");

        ColorInterface color = colorFactory.getColor(colorStr);
        ShapeInterface shape = shapeFactory.getShape(shapeStr);

        return color.fill() + " - " + shape.draw();
    }

    // 抽象工厂模式
    @Test
    public void testAbstractFactory() {
        System.out.println("---------------------------------------------------");
        System.out.println("AbstractFactory");
        String colorStr = "red";
        String shapeStr = "circle";
        String expResult = "red - circle";
        String result = getColorShape(colorStr, shapeStr);
        assertEquals(expResult, result);
    }

    // 建造者模式
    @Test
    public void testPrepareVegMeal() {
        System.out.println("---------------------------------------------------");
        System.out.println("Builder - prepareVegMeal");
        Builder builder = new Builder();
        AMeal vegMeal = builder.prepareVegMeal();
        System.out.println("素餐");
        vegMeal.showItems();
        System.out.println("总金额：" + vegMeal.getCost());
    }

    // 建造者模式
    @Test
    public void testPrepareNonVegMeal() {
        System.out.println("---------------------------------------------------");
        System.out.println("Builder - prepareNonVegMeal");
        Builder builder = new Builder();
        AMeal nonVegMeal = builder.prepareNonVegMeal();
        System.out.println("\n\n非素");
        nonVegMeal.showItems();
        System.out.println("总金额：" + nonVegMeal.getCost());
    }

    // 原型模式
    @Test
    public void testPrototype() {
        System.out.println("---------------------------------------------------");
        System.out.println("Prototype");

        ShapeCache.loadCache();

        AbstractShape s1 = ShapeCache.getShape("1");
        System.out.println("形状 : " + s1.getType());

        AbstractShape s2 = ShapeCache.getShape("2");
        System.out.println("形状 : " + s2.getType());

        AbstractShape s3 = ShapeCache.getShape("3");
        System.out.println("形状 : " + s3.getType());
    }
}
