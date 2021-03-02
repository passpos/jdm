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
    
    public void getBeanByRuntimeClass() {
        Student student = applicationContext.getBean(Student.class);
        ol(student);
    }
    
    public void getBeanBy() {
        
    }

    public <T> void ol(T arg) {
        System.out.println(arg);
    }
}
