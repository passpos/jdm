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

import java.util.function.Supplier;
import jdm.utils.demo.AbstractDemo;
import jdm.samples.stums.Student;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class SupplierDemo extends AbstractDemo {

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        String str = getString(() -> "任我行");
        ol(str);

        int i = getInteger(() -> 100);
        ol(i);

        Student stu = getStudent(() -> new Student(1, "任我行", 55, "河北"));
        ol(stu);
    }

    public String getString(Supplier<String> s) {
        return s.get();
    }

    public int getInteger(Supplier<Integer> s) {
        return s.get();
    }

    public Student getStudent(Supplier<Student> s) {
        return s.get();
    }

}
