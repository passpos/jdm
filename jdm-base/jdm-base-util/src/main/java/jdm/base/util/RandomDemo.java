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

import java.util.Random;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class RandomDemo {

    public static void rand() {
        Random r = new Random();

        int i = 0;
        while (i < 11) {
            i++;
            // 参数bound表示取值范围。包括0，不包括10；
            int number = r.nextInt(10);
            System.out.println("hello" + number);
        }
    }
}
