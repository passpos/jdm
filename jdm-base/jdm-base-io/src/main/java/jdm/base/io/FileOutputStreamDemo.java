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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import jdm.core.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class FileOutputStreamDemo extends AbstractDemo {

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        create02();
    }

    /*
     * 通过File对象创建文件输出流
     */
    public void create01() {
        FileOutputStream fos = null;
        String path = "src\\main\\java\\img\\68.txt";
        File file = new File(path);
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            ol(ex.getMessage());
        }
    }

    /*
     * 通过字符串创建文件输出流
     */
    public void create02() {
        FileOutputStream fos = null;
        String path = "src\\main\\java\\img\\68.txt";
        byte[] bytes = {102, 103, 104, 105, 106, 107, 108, 109, 110};
        String str = "今天天气不错！";
        byte[] len = str.getBytes();
        try {
            fos = new FileOutputStream(path, true);
        } catch (FileNotFoundException ex) {
            ol(ex.getMessage());
        }
        if (fos == null) {
            return;
        }
        try {
            // 换行＿
            fos.write("\n".getBytes());
            fos.write(System.getProperty("line.separator").getBytes());

            fos.write(100);
            fos.write(System.getProperty("line.separator").getBytes());

            fos.write(101);
            fos.write(System.getProperty("line.separator").getBytes());

            fos.write(bytes);
            fos.write(System.getProperty("line.separator").getBytes());

            fos.write(len);
            fos.write(System.getProperty("line.separator").getBytes());

            fos.write(len, 2, 4);
        } catch (IOException ex) {
            ol(ex.getMessage());
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                ol(ex.getMessage());
            }
            
        }
    }
}
