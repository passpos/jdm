/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.spring.entity;

import jdm.spring.aop.CalImpl;
import jdm.spring.aop.MyInvocationHandler;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class InvocationTest {

    @Test
    public void testCal() {
        CalImpl calImpl = new CalImpl();
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(calImpl);
        calImpl.add(1, 1);
        calImpl.sub(2, 1);
        calImpl.mul(2, 3);
        calImpl.div(10, 2);

    }
}
