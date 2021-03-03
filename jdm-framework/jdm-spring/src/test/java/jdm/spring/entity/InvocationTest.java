/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.spring.entity;

import jdm.spring.aop.CalImpl;
import jdm.spring.aop.Calcuator;
import jdm.spring.aop.MyInvocationHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class InvocationTest {

    @BeforeEach
    public void before() {
        System.out.println("-------------------------");
    }

    @Test
    public void testCal() {
        CalImpl calImpl = new CalImpl();

        MyInvocationHandler handler = new MyInvocationHandler();
        Calcuator cal2 = (Calcuator) handler.bind(calImpl);

        cal2.add(1, 1);
        cal2.sub(2, 1);
        cal2.mul(2, 3);
        cal2.div(10, 2);

    }
}
