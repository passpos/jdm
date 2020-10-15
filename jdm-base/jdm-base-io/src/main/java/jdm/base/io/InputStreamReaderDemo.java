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
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import jdm.utils.demo.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class InputStreamReaderDemo extends AbstractDemo {

    private FileInputStream fis = null;
    private InputStreamReader isr = null;
    private final String path = "src\\main\\java\\img\\68.txt";

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        setFis();
        setIsr();
        if (isr != null) {
            try {
                readDemo();
                isr.close();
            } catch (IOException ex) {
                ol(ex.getMessage());
                ol(ex.getLocalizedMessage());
            }
        }
    }

    public void setFis() {
        try {
            this.fis = new FileInputStream(path);
        } catch (FileNotFoundException ex) {
            ol(ex.getMessage());
        }
    }

    public void setIsr() {
        if (fis != null) {
            try {
                this.isr = new InputStreamReader(fis, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                ol(ex.getMessage());
            }
        }
    }

    public void readDemo() throws IOException {

        // 1次读取一个字符
        int ch = isr.read();
        ol(ch);
        ol((char) ch);

        // 1次读取一个字符数组
        char[] cbuf = new char[11];
        isr.read(cbuf);
        ol(new String(cbuf));
    }
}
