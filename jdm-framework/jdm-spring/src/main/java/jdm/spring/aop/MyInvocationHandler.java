/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class MyInvocationHandler implements InvocationHandler {

    /**
     * 接收委托对象
     */
    private Object object = null;

    /**
     * 返回代理对象
     * @param object
     * @return
     */
    public Object bind(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "方法的参数是：" + Arrays.toString(args));
        Object result = method.invoke(object, args);
        System.out.println(method.getName() + "的结果是：" + result);
        return null;
    }

}
