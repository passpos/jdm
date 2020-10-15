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
package jdm.base.util;

import java.util.ArrayList;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ArrayListDemo {

    public static ArrayList<String> list;

    public static void show() {
        demo();
        setList();
        traversal3();
    }

    public static void demo() {
        ArrayList<String> al = new ArrayList<>();
        al.add("hello");
        al.add("world");
        al.add(0, "这是");
        al.add(3, "这是");
        System.out.println("al：" + al);
        System.out.println("al：" + al.size());
        al.remove(2);
        System.out.println("al：" + al.size());
    }

    public static void setList() {
        list = new ArrayList<>();
        list.add(0, "这是");
        list.add("hello");
        list.add("world");
    }

    public static void traversal1() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void traversal2() {
        for (String l : list) {
            System.out.println(l);
        }
    }

    public static void traversal3() {
        list.forEach((l) -> {
            System.out.println(l);
        });
    }

    public static void traversal4() {
        list.forEach(System.out::println);
    }
}
