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
import creational.factory.shape.RectangleShape;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import structural.adapter.AudioPlayer;
import structural.bridge.CircleShape;
import structural.bridge.GreenCircle;
import structural.bridge.RedCircle;
import structural.composite.Composite;
import structural.decorator.AbstractDecorator;
import structural.decorator.RedShapeDecorator;
import structural.filter.AndCriteria;
import structural.filter.CriteriaFemale;
import structural.filter.CriteriaInterface;
import structural.filter.CriteriaMale;
import structural.filter.CriteriaSingle;
import structural.filter.OrCriteria;
import structural.filter.Person;

/**
 * 1.创建型模式
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
 * 2.结构型模式
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
 * 装饰器模式（Decorator Pattern）
 * 外观模式（Facade Pattern）
 * 享元模式（Flyweight Pattern）
 * 代理模式（Proxy Pattern）
 *
 *
 * 3.行为型模式
 * 这些设计模式特别关注对象之间的通信。
 *
 * 模板模式
 * 观察者模式
 * 状态模式
 * 责任链模式
 *
 * 4.J2EE 模式
 * 这些设计模式特别关注表示层。这些模式是由 Sun Java Center 鉴定的。
 *
 * MVC 模式（MVC Pattern）
 * 业务代表模式（Business Delegate Pattern）
 * 组合实体模式（Composite Entity Pattern）
 * 数据访问对象模式（Data Access Object Pattern）
 * 前端控制器模式（Front Controller Pattern）
 * 拦截过滤器模式（Intercepting Filter Pattern）
 * 服务定位器模式（Service Locator Pattern）
 * 传输对象模式（Transfer Object Pattern）
 *
 *
 * 设计模式的六大原则
 *
 * 1、开闭原则（Open Close Principle）
 * 开闭原则的意思是：对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一
 * 个热插拔的效果。简言之，是为了使程序的扩展性好，易于维护和升级。想要达到这样的效果，我们需要使用
 * 接口和抽象类，后面的具体设计中我们会提到这点。
 *
 * 2、里氏代换原则（Liskov Substitution Principle）
 * 里氏代换原则是面向对象设计的基本原则之一。里氏代换原则中说，任何基类可以出现的地方，子类一定可
 * 以出现。LSP 是继承复用的基石，只有当派生类可以替换掉基类，且软件单位的功能不受到影响时，基类才
 * 能真正被复用，而派生类也能够在基类的基础上增加新的行为。里氏代换原则是对开闭原则的补充。实现开闭
 * 原则的关键步骤就是抽象化，而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽
 * 象化的具体步骤的规范。
 *
 * 3、依赖倒转原则（Dependence Inversion Principle）
 * 这个原则是开闭原则的基础，具体内容：针对接口编程，依赖于抽象而不依赖于具体。
 *
 * 4、接口隔离原则（Interface Segregation Principle）
 * 这个原则的意思是：使用多个隔离的接口，比使用单个接口要好。它还有另外一个意思是：降低类之间的耦合度。由此可见，其实设计模式就是从大型软件架构出发、便于升级和维护的软件设计思想，它强调降低依赖，降低耦合。
 *
 * 5、迪米特法则，又称最少知道原则（Demeter Principle）
 * 最少知道原则是指：一个实体应当尽量少地与其他实体之间发生相互作用，使得系统功能模块相对独立。
 *
 * 6、合成复用原则（Composite Reuse Principle）
 * 合成复用原则是指：尽量使用合成/聚合的方式，而不是使用继承。
 *
 * @author passpos <paiap@outlook.com>
 */
public class PatternTest {

    public PatternTest() {
    }

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

        structural.bridge.AbstractShape cs1 = new CircleShape(100, 100, 10, new RedCircle());
        cs1.draw();

        structural.bridge.AbstractShape cs2 = new CircleShape(100, 100, 10, new GreenCircle());
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
        System.out.println("Circle with normal border");
        ShapeInterface c1 = new creational.factory.shape.CircleShape();
        c1.draw();

        System.out.println("\nCircle of red border");
        ShapeInterface c2 = new creational.factory.shape.CircleShape();
        AbstractDecorator redCircle = new RedShapeDecorator(c2);
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        AbstractDecorator redRectangle = new RedShapeDecorator(new RectangleShape());
        redRectangle.draw();
    }
    /* -------------------------------------------------------------------------
     * 行为型
     * ---------------------------------------------------------------------- */
}
