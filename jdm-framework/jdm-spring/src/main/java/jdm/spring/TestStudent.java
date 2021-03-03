/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.spring;

import jdm.spring.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class TestStudent {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

    public static void main(String[] args) {
        TestStudent ts = new TestStudent();
        ts.getBeanById();
    }

    public void getBeanById() {
        Student student = (Student) applicationContext.getBean("student");
        ol(student);
    }

    /**
     * 这种方式存在一个问题，配置文件中一个数据类型的对象只能有一个实例例，否则
     * 会抛出异常，因为没有唯一的 bean。
     */
    public void getBeanByRuntimeClass() {
        Student student = applicationContext.getBean(Student.class);
        ol(student);
    }
    
    public void getBeanByConstructor() {
        Student student = (Student) applicationContext.getBean("student2");
        ol(student);
    }

    public <T> void ol(T arg) {
        System.out.println(arg);
    }
}
