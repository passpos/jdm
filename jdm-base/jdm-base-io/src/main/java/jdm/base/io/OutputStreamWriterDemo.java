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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import jdm.core.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class OutputStreamWriterDemo extends AbstractDemo {

    private FileOutputStream fos = null;
    private FileInputStream fis = null;
    private OutputStreamWriter osw = null;
    private InputStreamReader isr = null;
    private final String path = "src\\main\\java\\img\\68.txt";

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        writeText();
        writeDemo();
//        readText();

        try {
            if (osw != null) {
                osw.close();
            }
            if (isr != null) {
                isr.close();
            }
        } catch (IOException ex) {
            ol(ex.getMessage());
        }
    }

    public void setFos() {
        File file = new File(path);
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            ol(ex.getMessage());
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
        try {
//            this.isr = new InputStreamReader(fis, "GBK");
            this.isr = new InputStreamReader(fis, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            ol(ex.getMessage());
        }
    }

    public void setOsw() {
        try {
//            this.osw = new OutputStreamWriter(fos, "GBK");
            this.osw = new OutputStreamWriter(fos, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            ol(ex.getMessage());
        }
    }

    public void writeText() {
        setFos();
        setOsw();
        try {
            osw.write("blabla三丢贿");
            osw.flush();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public void readText() {
        setFis();
        setIsr();
        int ch = 0;
        while (ch != -1) {
            try {
                ch = isr.read();
            } catch (IOException ex) {
                ex.getMessage();
            }
            o((char) ch);
        }
        try {
            isr.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public void writeDemo() {
        try {
            osw.write(System.getProperty("line.separator"));
            // 写入字符
            osw.write(97);
            osw.flush();

            // 写入字符数组
            char[] cbuf = {98, 99, 100, 101, 102, 103, 104, 105};
            osw.write(cbuf);

            // 写入字符数组的一部分
            osw.write(cbuf, 2, 4);

            // 写入字符串
            String str = "关于的三个法院下半场吧女色的极端";
            osw.write(str);

            // 写入字符串的一部分
            osw.write(System.getProperty("line.separator"));
            osw.write(str, 5, 6);
            osw.flush();
        } catch (IOException ex) {
            ol(ex.getMessage());
        }
    }
}
