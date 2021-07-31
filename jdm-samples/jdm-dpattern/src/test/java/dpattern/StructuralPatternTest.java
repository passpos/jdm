/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpattern;

import creational.factory.shape.RectangleShape;
import creational.factory.shape.ShapeInterface;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import structural.adapter.AudioPlayer;
import structural.bridge.AbstractShape;
import structural.bridge.CircleShape;
import structural.bridge.GreenCircle;
import structural.bridge.RedCircle;
import structural.composite.Composite;
import structural.decorator.AbstractDecorator;
import structural.decorator.RedShapeDecorator;
import structural.facade.Facade;
import structural.filter.AndCriteria;
import structural.filter.CriteriaFemale;
import structural.filter.CriteriaInterface;
import structural.filter.CriteriaMale;
import structural.filter.CriteriaSingle;
import structural.filter.OrCriteria;
import structural.filter.Person;
import structural.flyweight.Flyweight;
import structural.proxy.Proxy;

/**
 * 结构型模式
 *
 * 这些设计模式关注类和对象的组合。继承的概念被用来组合接口和定义组合对象获得新功能的方式。
 *
 * 适配器模式（Adapter Pattern）
 * structural.adapter.MediaAdapter
 * structural.adapter.AudioPlayer
 *
 * 桥接模式（Bridge Pattern）
 * structural.bridge.AbstractShape
 * structural.bridge.CircleShape
 *
 * 过滤器模式（Filter、CriteriaInterface Pattern）
 * structural.filter.CriteriaInterface
 *
 * 组合模式（Composite Pattern）
 * structural.composite.Composite
 *
 * 装饰器模式（Decorator Pattern）
 * structural.decorator.AbstractDecorator
 *
 * 外观模式（Facade Pattern）
 * structural.facade.Facade
 *
 * 享元模式（Flyweight Pattern）
 * structural.flyweight.Flyweight
 *
 * 代理模式（Proxy Pattern）
 * structural.proxy.Proxy
 *
 * @author passpos <paiap@outlook.com>
 */
public class StructuralPatternTest {

    /* -------------------------------------------------------------------------
     * 结构型
     * ---------------------------------------------------------------------- */
    // 适配器模式
    @Test
    public void testAdapter() {
        System.out.println("---------------------------------------------------");
        System.out.println("Adapter");

        AudioPlayer aplayer = new AudioPlayer();

        aplayer.play("mp3", "beyond the horizon.mp3");
        aplayer.play("mp4", "alone.mp4");
        aplayer.play("vlc", "far far away.vlc");
        aplayer.play("avi", "mind me.avi");
    }

    // 桥接模式
    @Test
    public void testBridge() {
        System.out.println("---------------------------------------------------");
        System.out.println("Bridge");

        AbstractShape cs1 = new CircleShape(100, 100, 10, new RedCircle());
        cs1.draw();

        AbstractShape cs2 = new CircleShape(100, 100, 10, new GreenCircle());
        cs2.draw();
    }

    // 过滤器模式
    @Test
    public void testCriteria() {
        System.out.println("---------------------------------------------------");
        System.out.println("Criteria|过滤器模式");
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        CriteriaInterface male = new CriteriaMale();
        CriteriaInterface female = new CriteriaFemale();
        CriteriaInterface single = new CriteriaSingle();
        CriteriaInterface singleMale = new AndCriteria(single, male);
        CriteriaInterface singleOrFemale = new OrCriteria(single, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));
    }

    private void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName()
                    + ", Gender : " + person.getGender()
                    + ", Marital Status : " + person.getMaritalStatus()
                    + " ]");
        }
    }

    // 组合模式
    @Test
    public void testComposite() {
        System.out.println("---------------------------------------------------");
        System.out.println("Composite|组合模式");
        Composite.start();
    }

    // 装饰器模式
    @Test
    public void testDecorator() {
        System.out.println("---------------------------------------------------");
        System.out.println("Decorator|装饰器模式");
        // 装饰前
        System.out.println("Circle with normal border");
        ShapeInterface c1 = new creational.factory.shape.CircleShape();
        c1.draw();

        // 装饰后
        System.out.println("\nCircle of red border");
        ShapeInterface c2 = new creational.factory.shape.CircleShape();
        AbstractDecorator redCircle = new RedShapeDecorator(c2);
        redCircle.draw();

        // 装饰后
        System.out.println("\nRectangle of red border");
        AbstractDecorator redRectangle = new RedShapeDecorator(new RectangleShape());
        redRectangle.draw();
    }

    // 外观模式
    @Test
    public void testFacade() {
        System.out.println("---------------------------------------------------");
        System.out.println("Facade|外观模式");
        Facade shapeMaker = new Facade();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }

    // 外观模式
    @Test
    public void testFlyweight() {
        System.out.println("---------------------------------------------------");
        System.out.println("Flyweight|外观模式");
        Flyweight.start();
    }

    // 代理模式
    @Test
    public void testProxy() {
        System.out.println("---------------------------------------------------");
        System.out.println("Proxy|代理模式");
        Proxy proxy = new Proxy("test_10mb.jpg");

        // 图像将从磁盘加载
        proxy.display();
        System.out.println("");

        // 图像不需要从磁盘加载
        proxy.display();
    }
}
