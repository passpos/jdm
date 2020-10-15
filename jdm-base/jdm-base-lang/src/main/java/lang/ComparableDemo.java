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

import java.util.TreeSet;
import jdm.utils.demo.AbstractDemo;
import utils.entity.demo.sample.Teacher;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ComparableDemo extends AbstractDemo {

    TreeSet<Teacher> ts;

    @Override
    public void index() {
        ts = new TreeSet<>();
        baseDemo();
    }

    public void baseDemo() {
        Teacher t1 = new Teacher("aa", 21, 15000);
        Teacher t2 = new Teacher("bb", 29, 16000);
        Teacher t3 = new Teacher("cc", 45, 15700);
        Teacher t4 = new Teacher("dd", 34, 18000);
        Teacher t5 = new Teacher("ee", 15, 13000);
        ts.add(t1);
        ts.add(t2);
        ts.add(t3);
        ts.add(t4);
        ts.add(t5);

        for (Teacher t : ts) {
            System.out.println(t);
        }
    }

}
