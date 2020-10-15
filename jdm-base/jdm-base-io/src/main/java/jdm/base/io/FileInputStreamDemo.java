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
package jdm.base.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import jdm.utils.demo.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class FileInputStreamDemo extends AbstractDemo {

    public FileInputStream fis = null;

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        try {
            fis = new FileInputStream("src\\main\\java\\img\\68.txt");
        } catch (FileNotFoundException ex) {
            ol(ex.getMessage());
        }
        if (fis == null) {
            return;
        }
        try {
            String str = "";
            for (int i = 0; i < 30; i++) {
                byte[] by = new byte[24];
                int len = fis.read(by, 0, 12);
                if (len == -1) {
                    break;
                } else {
                }
                readAndShow02(by, len);
                str += exchange(by);
            }
            ol(str);
            fis.close();
        } catch (IOException ex) {
            ol(ex.getMessage());
        }
    }

    public void readAndShow01() throws IOException {
        int by = fis.read();
        if (by == -1) {
            return;
        }
        ol(by);
        ol((char) by);
    }

    public void readAndShow02(byte[] by, int len) throws IOException {
        ol("读取到的字节数：" + len);
        ol("字节数组：" + by);
        ol("字符串：" + new String(by));
        ol("----------");
    }

    public String exchange(byte[] b) {
        return new String(b);
    }
}
