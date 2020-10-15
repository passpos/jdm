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
package lang;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class StringBuilderDemo {

    public static StringBuilder sb = null;

    public static void show() {
        System.out.println("创建StringBuilder：");
        getInstance();

        System.out.println("追加内容：");
        runAppend();

        System.out.println("反转内容：");
        runReverse();

        System.out.println("String与StringBuilder相互转换：");
        toStringObj();
        toStringBuilder();
    }

    // 实例化StringBuilder
    public static void getInstance() {
        sb = new StringBuilder();
        System.out.println("sb：" + sb);
        System.out.println("sb.length()：" + sb.length());

        StringBuilder sb2 = new StringBuilder("hello");
        System.out.println("sb2.length()：" + sb2.length());
        System.out.println("sb2.append(\" world\")：" + sb2.append(" world"));

    }

    // 为空StringBuilder添加内容
    public static void runAppend() {
        StringBuilder sb3 = sb.append(" world");
        System.out.println("sb：" + sb);
        System.out.println("sb3：" + sb3);
        System.out.println("sb.equals(sb3)：" + (sb.equals(sb3)));
    }

    // 反转
    public static void runReverse() {
        sb.reverse();
        System.out.println("sb：" + sb);
    }

    // StringBuilder转换为String
    public static void toStringObj() {
        System.out.println("通过StringBuilder的toString()方法转换为String：");
        sb.toString();
        System.out.println(sb);
    }

    // String转换为StringBuilder
    public static void toStringBuilder() {
        System.out.println("通过StringBuilder的规则方法实现String转换为SB：");
        String str = "dfhfhh";
        StringBuilder sbstr = new StringBuilder(str);
        System.out.println(sbstr);
    }
}
