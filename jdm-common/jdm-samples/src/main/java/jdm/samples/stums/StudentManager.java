/*
 * Copyright (C) 2020 realpai <paiap@outlook.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jdm.samples.stums;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;
import jdm.core.entity.Student;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class StudentManager {

    public static Scanner sc;
    public static ArrayList<Student> list;
    public static int markId;

    public static void main(String[] args) {
        show();
    }

    public static void show() {
        sc = new Scanner(System.in);
        list = new ArrayList<>();

        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入数字：");

            String line = sc.nextLine();
            switch (line) {
                case "1":
//                    System.out.println("添加学生");
                    addStudent();
                    break;
                case "2":
//                    System.out.println("删除学生");
                    deleteStudent();
                    break;
                case "3":
//                    System.out.println("修改学生");
                    editStudent();
                    break;
                case "4":
//                    System.out.println("查看所有学生");
                    findAllStudents();
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    System.exit(0);     // 向JVM发送退出命令；
                    break;
                default:
                    System.out.println("输入错误：\n请输入1-5的整数");
                    break;
            }
        }
    }

    public static void addStudent() {
        int sid;
        while (true) {
            System.out.println("请输入学生学号：");
            int inputId = Integer.valueOf(sc.nextLine());
//        int inputId = sc.nextInt();   // 这里使用nextInt()会跳过姓名的输入；
            if (inputId > 0) {
                sid = inputId;
            } else {
                sid = -inputId;
            }
            if (hasStudent(sid)) {
                System.out.println("学号已经存在，请更换学号！");
            } else {
                break;
            }
        }

        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();

        System.out.println("请输入学生年龄：");
        int age = Integer.valueOf(sc.nextLine());

        System.out.println("请输入学生住址：");
        String address = sc.nextLine();

        Student s = new Student(sid, name, age, address);
        list.add(s);
        System.out.println("添加学生成功：");
    }

    public static boolean hasStudent(int sid) {
        boolean flag = false;
        for (Student s : list) {
            if (s.getSid() == sid) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void findAllStudents() {
        if (list.size() > 0) {
            System.out.println("学号\t姓名\t年龄\t居住地");
            list.forEach((x) -> System.out.println(x.getSid()
                    + "\t" + x.getName()
                    + "\t" + x.getAge()
                    + "\t" + x.getAddress()));
        } else {
            System.out.println("无信息！\n请先添加信息再查询");
        }
    }

    public static void deleteStudent() {
        System.out.println("请输入需要删除的学生的学号");
        int sid = Integer.valueOf(sc.nextLine());
        markId = -1;

        for (Student s : list) {
            if (s.getSid() == sid) {
                list.remove(s);
                markId = sid;
                System.out.println("删除学生成功！");
                break;
            }
        }
        if (markId == -1) {
            System.out.println("查询不到学生信息，请核实后再进行操作！");
        }
    }

    public static void editStudent() {
        System.out.println("请输入你要修改的学生的学号：");
        int sid = Integer.valueOf(sc.nextLine());
        markId = -1;
        list.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student s) {
                if (s.getSid() == sid) {
                    System.out.println("请输入学生的新姓名：");
                    s.setName(sc.nextLine());
                    System.out.println("请输入学生的新年龄：");
                    s.setAge(Integer.valueOf(sc.nextLine()));
                    System.out.println("请输入学生的新住址：");
                    s.setAddress(sc.nextLine());
                    markId = sid;
                    System.out.println("修改学生信息成功！");
                }
            }
        });
        if (markId == -1) {
            System.out.println("查询不到学生信息，请核实后再进行操作！");
        }

    }
}
