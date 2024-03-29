/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.composite;

/**
 * 组合模式
 *
 * 组合模式（Composite Pattern），又叫部分整体模式，是用于把一组相似的对象当作一个单一的对象。
 * 组合模式依据树形结构来组合对象，用来表示部分以及整体层次。这种类型的设计模式属于结构型模式，它创
 * 建了对象组的树形结构。
 *
 * 这种模式创建了一个包含自己对象组的类。该类提供了修改相同对象组的方式。
 *
 * 我们通过下面的实例来演示组合模式的用法。实例演示了一个组织中员工的层次结构。
 * 介绍
 *
 * a.意图
 * 将对象组合成树形结构以表示"部分-整体"的层次结构。组合模式使得用户对单个对象和组合对象的使用具有
 * 一致性。
 *
 * b.主要解决
 * 它在我们树型结构的问题中，模糊了简单元素和复杂元素的概念，客户程序可以像处理简单元素一样来处理复
 * 杂元素，从而使得客户程序与复杂元素的内部结构解耦。
 *
 * c.何时使用
 * 1.您想表示对象的部分-整体层次结构（树形结构）。
 * 2.您希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
 *
 * d.如何解决
 * 树枝和叶子实现统一接口，树枝内部组合该接口。
 *
 * e.关键代码
 * 树枝内部组合该接口，并且含有内部属性 List，里面放 Component。
 *
 * f.应用实例
 * 1.算术表达式包括操作数、操作符和另一个操作数，其中，另一个操作符也可以是操作数、操作符和另一个
 * 操作数。
 * 2.在 JAVA AWT 和 SWING 中，对于 Button 和 Checkbox 是树叶，Container 是树枝。
 *
 * g.优点
 * 1.高层模块调用简单。
 * 2.节点自由增加。
 *
 * h.缺点
 * 在使用组合模式时，其叶子和树枝的声明都是实现类，而不是接口，违反了依赖倒置原则。
 *
 * i.使用场景
 * 部分、整体场景，如树形菜单，文件、文件夹的管理。
 *
 * j.注意事项
 * 定义时为具体类。
 *
 * @author passpos <paiap@outlook.com>
 */
public class Composite {

    public static void start() {
        Employee CEO = new Employee("John", "CEO", 30000);

        // CEO下属：销售主管、市场主管
        Employee headSales = new Employee("Robert", "Head Sales", 20000);
        CEO.add(headSales);
        Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);
        CEO.add(headMarketing);

        // 销售主管下属：
        Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
        headSales.add(salesExecutive1);
        Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);
        headSales.add(salesExecutive2);

        // 市场主管下属：
        Employee clerk1 = new Employee("Laura", "Marketing", 10000);
        headMarketing.add(clerk1);
        Employee clerk2 = new Employee("Bob", "Marketing", 10000);
        headMarketing.add(clerk2);

        //打印该组织的所有员工
        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println("下属：");
                System.out.println(employee);
            }
            System.out.println("<------------");
        }
    }
}
