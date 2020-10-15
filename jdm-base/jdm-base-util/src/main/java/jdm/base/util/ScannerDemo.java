/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.base.util;

import java.util.Scanner;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ScannerDemo {

    public void scan() {
        Scanner sc = new Scanner(System.in);    // 从系统（控制台）输入中获取数据；

        System.out.println("请输入a的值：");
        int a = sc.nextInt();

        System.out.println("请输入b的值：");
        int b = sc.nextInt();

        System.out.println("请输入c的值：");
        int c = sc.nextInt();

        System.out.println(a + b + c);

    }
}
