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

import java.util.Comparator;
import java.util.TreeSet;
import jdm.utils.demo.AbstractDemo;
import utils.entity.demo.sample.Teacher;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class CmparatorDemo extends AbstractDemo {

    private TreeSet<Teacher> ts;

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        Teacher t1 = new Teacher("香茗", 19, 45645);
        Teacher t2 = new Teacher("桂枝", 22, 54894);
        Teacher t3 = new Teacher("嬉春", 16, 54548);
        Teacher t4 = new Teacher("香槟", 18, 65146);
        ts = new TreeSet<Teacher>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher t1, Teacher t2) {
                int p1 = t1.getPayment() - t2.getPayment();
                int p2 = t1.getName().compareTo(t2.getName());
                int p3 = p1 == 0 ? p2 : p1;
                return p3;
            }
        });
        ts.add(t1);
        ts.add(t2);
        ts.add(t3);
        ts.add(t4);

        for (Teacher t : ts) {
            System.out.println(t);
        }
    }

}
