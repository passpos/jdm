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
package jdm.algorithm;

import jdm.core.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class RecursionDemo extends AbstractDemo {

    public static int sum;

    @Override
    public void index() {
        ol(f(5));
        ol(sum);
    }

    // 递归求阶乘
    public static int f(int num) {
        if (num == 1) {
            return 1;
        } else {
            int res = num * f(num - 1);
            return res;
        }
    }
}
