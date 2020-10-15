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

import java.util.HashSet;
import jdm.utils.demo.AbstractDemo;
import jdm.samples.stums.Student;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class HashSetDemo extends AbstractDemo {

    private HashSet<Student> hs;

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        hs = new HashSet<>();
        Student st1 = new Student(0, "a", 22, "dsgf");
        Student st2 = new Student(1, "b", 25, "bhg");
        Student st3 = new Student(1, "b", 25, "bhg");
        hs.add(st1);
        hs.add(st2);
        hs.add(st3);
        // Student未重写hashCode()和equals()方法时，集合中会将两个数据相同的Student认为是不同的两个；

        for (Student h : hs) {
            System.out.println(h);
        }
    }

}
