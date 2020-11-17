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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jdm.utils.demo.AbstractDemo;
import utils.entity.demo.sample.Student;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class CollectionDemo extends AbstractDemo {

    Collection<Student> collStudent;


    @Override
    public void index() {
        baseDemo();
        iter();
        nesting();
    }

    public void baseDemo() {
        Collection<String> s = new ArrayList<>();
        s.add("hello");
        s.add("world");
        System.out.println(s);

        System.out.println(s.add("java"));
        s.add("java");
        s.remove("java");
        System.out.println(s.contains("java"));
        System.out.println(s.isEmpty());
        System.out.println(s.size());
        s.clear();
    }

    public void iter() {
        Collection<String> s = new ArrayList<>();
        s.add("hello");
        s.add("world");
        s.add("java");
        Iterator<String> iter = s.iterator();
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        if (iter.hasNext()) {
            iter.next();
        }

        // 遍历方式1
        s.forEach((String t) -> {
            System.out.println(t);
        });

        // 遍历方式2
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public void addStudent(Student stu) {
        collStudent = new ArrayList<>();
        collStudent.add(stu);
    }

    public void nesting() {
        ArrayList<HashMap<String, String>> al = new ArrayList<>();
        HashMap<String, String> hm1 = new HashMap<>();
        HashMap<String, String> hm2 = new HashMap<>();
        HashMap<String, String> hm3 = new HashMap<>();

        addElements(hm1);
        addElements(hm2);
        addElements(hm3);

        al.add(hm1);
        al.add(hm2);
        al.add(hm3);
        traversal(al);
    }

    public void traversal(ArrayList<HashMap<String, String>> al) {
        for (HashMap<String, String> hm : al) {
            Set<String> ks = hm.keySet();
            for (String k : ks) {
                String v = hm.get(k);
                ol("通过keySet()方法遍历：" + k + "是" + v);
            }
        }

        for (HashMap<String, String> hm : al) {
            Set<Map.Entry<String, String>> es = hm.entrySet();
            for (Map.Entry<String, String> e : es) {
                ol("通过entrySet()方法遍历：" + e.getKey() + "是" + e.getValue());
            }
        }
    }

    public void addElements(HashMap<String, String> map) {
        map.put("第1句", "hello");
        map.put("第2句", "world");
        map.put("第3句", "java");
        map.put("第4句", "集合");
        map.put("第5句", "嵌套");
    }
}
