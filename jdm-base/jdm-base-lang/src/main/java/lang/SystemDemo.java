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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdm.core.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class SystemDemo extends AbstractDemo {

    InputStream in = null;
    PrintStream out = null;

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        in = System.in;
        out = System.out;
//        method01();
        try {
            method02();
        } catch (IOException ex) {
            ol(ex.getMessage());
        }
    }

    public void method01() {
        try {
            int byt;
            while ((byt = in.read()) != -1) {
                ol((char) byt);
            }
        } catch (IOException ex) {
            Logger.getLogger(SystemDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void method02() throws IOException {
        InputStreamReader isr = new InputStreamReader(in, "UTF-8");

        // 一次读取一行数据，这类似于Scanner；
        BufferedReader br = new BufferedReader(isr);

        ol("--------请输入一句话并回车：");
        String str = br.readLine();
        ol("你输入的是：" + str);
    }

    public void method03() {

    }
}
