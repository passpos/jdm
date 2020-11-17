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

import java.util.function.Function;
import jdm.core.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class FunctionDemo extends AbstractDemo {

    public static void main(String[] args) {
        FunctionDemo fd = new FunctionDemo();
        fd.index();
    }

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        convert("1265", s -> Integer.parseInt(s));
        convert("15", Integer::parseInt);
    }

    public void convert(String s, Function<String, Integer> f) {
        int i = f.apply(s);
        ol(i);
    }
}
