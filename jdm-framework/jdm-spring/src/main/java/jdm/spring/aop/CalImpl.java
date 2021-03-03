/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.spring.aop;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class CalImpl implements Calcuator {

    @Override
    public int add(int num1, int num2) {
        int res = num1 + num2;
        return res;
    }

    @Override
    public int sub(int num1, int num2) {
        int res = num1 - num2;
        return res;
    }

    @Override
    public int mul(int num1, int num2) {
        int res = num1 * num2;
        return res;
    }

    @Override
    public int div(int num1, int num2) {
        int res = num1 / num2;
        return res;
    }

}
