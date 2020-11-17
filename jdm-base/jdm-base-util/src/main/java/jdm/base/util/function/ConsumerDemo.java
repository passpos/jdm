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
package jdm.base.util.function;

import java.util.function.Consumer;
import jdm.utils.demo.AbstractDemo;
import jdm.utils.entity.Student;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ConsumerDemo extends AbstractDemo {

    private String str1 = "嘿嘿嘿";
    private String str2 = "嘿嘿嘿";
    private String str3 = "嘿嘿嘿";

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        ol("--------------------String1:");
        eatString(str1, (s) -> ol(s.substring(1)));

        // 这里，两次输出的字符串一致，是由于String是特殊的final类型；
        ol("--------------------String2:");
        eatTwiceString(
                str2,
                (s) -> ol(str2 = s.substring(1))
        );
        ol("str2的值是：" + str2);

        ol("--------------------String3:");
        eatTwiceString(
                str3,
                (s) -> ol(str3 = s.substring(1)),
                (s) -> ol(str3 = s.substring(1))
        );

        ol("--------------------Student1:");
        Student stu1 = new Student(1, "嘿嘿嘿", 55, "河北");
        ol(stu1);
        eatTwiceStudent(
                stu1,
                (s) -> {
                    s.setName(s.getName().substring(1));
                    ol(s);
                }
        );

        ol("--------------------Student2:");
        Student stu2 = new Student(1, "嘿嘿嘿", 55, "河北");
        ol(stu2);
        eatTwiceStudent(
                stu2,
                (s) -> {
                    s.setName(s.getName().substring(1));
                    ol(s);
                },
                (s) -> {
                    s.setName(s.getName().substring(1));
                    ol(s);
                }
        );
    }

    /**
     * 当两次操作一致时，可以使用两个参数的方法
     * @param str
     * @param c
     */
    public void eatString(String str, Consumer<String> c) {
        c.accept(str);
    }

    public void eatTwiceString(String str, Consumer<String> c) {
        c.andThen(c).accept(str);
    }

    /**
     * 当两次操作不一致时，可以使用三个参数的方法
     * @param str
     * @param c1
     * @param c2
     */
    public void eatTwiceString(String str, Consumer<String> c1, Consumer<String> c2) {
        c1.andThen(c2).accept(str);
    }

    public void eatTwiceStudent(Student stu, Consumer<Student> c) {
        c.andThen(c).accept(stu);
    }

    /**
     * 当两次操作不一致时，可以使用三个参数的方法
     * @param stu
     * @param c1
     * @param c2
     */
    public void eatTwiceStudent(Student stu, Consumer<Student> c1, Consumer<Student> c2) {
        c1.andThen(c2).accept(stu);
    }
}
