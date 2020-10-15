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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import jdm.utils.demo.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ListDemo extends AbstractDemo {

    private List<String> list;

    @Override
    public void index() {
        baseDemo();
        member();
    }

    public void baseDemo() {
        list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);
        list.add("java");
        System.out.println(list);
    }

    public void member() {
        list.get(0);
        list.remove(1);
        try {
            list.remove(110);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("没有这个索引的元素");
        }

        list.set(0, "第一位");
        System.out.println(list.get(0));
    }

    public void iter() {
        Iterator<String> iter = list.iterator();

        // for循环：
        for (int i = 0; i < list.size(); i++) {
            String t = list.get(i);
            System.out.println(t);
        }

        // 增强的for循环：
        for (String li : list) {
            System.out.println(li);
        }

        // while循环（迭代器）：
        while (iter.hasNext()) {
            String str = iter.next();
            System.out.println(str);
        }

        // 或使用函数式接口：
        list.forEach((String t) -> {
            System.out.println(t);
        });
    }

    public void listIterator() {
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasPrevious()) {
            listIterator.add("new");
            System.out.println(listIterator.previous());
        }
    }
}
