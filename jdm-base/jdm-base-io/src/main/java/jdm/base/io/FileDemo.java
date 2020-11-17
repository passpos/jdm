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
import java.io.IOException;
import jdm.core.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class FileDemo extends AbstractDemo {

    private File f;

    public static void main(String[] args) {
        new FileDemo().index();
    }

    @Override
    public void index() {
        f = new File("D:\\aa");

        // baseDemo();
        // traversal(f);
        pathDemo();
    }

    /**
     * File支持的路径格式：
     * 绝对路径总是从“文件系统根”开始；
     * 相对路径则是从“项目根”开始；
     */
    public void baseDemo() {
        File f1 = new File("D:/");
        ol(f1);

        File f2 = new File("D://");
        ol(f2);

        File f3 = new File("D:\\");
        ol(f3);

        File f4 = new File("D:\\aa\\68.gif");
        ol(f4);

        File f5 = new File("D:\\aa", "68.gif");
        ol(f5);

        File f6 = new File("D:\\aa");
        File f7 = new File(f6, "68.gif");
        ol(f7);

        File f8 = new File("src\\wei.txt");
    }

    public void createDemo() {
        File f1 = new File("D:\\aa\\wei.txt");
        try {
            ol(f1.createNewFile());
        } catch (IOException ex) {
            ol(ex.getMessage());
        }

        File f2 = new File("D:\\aa\\aa");
        ol(f2.mkdir());

        File f3 = new File("D:\\aa\\bb\\cc");
        ol(f3.mkdirs());
    }

    public void judgementDemo() {
        ol("----------is:");

        ol(f.isDirectory());
        ol(f.isFile());
        ol(f.exists());

    }

    public void getDemo() {
        ol("----------get:");
        ol(f.getAbsolutePath());
        ol(f.getName());
        ol(f.getPath());

        ol("----------list:");
        for (String l : f.list()) {
            ol(l);
        }

        ol("----------listFiles:");
        for (File lf : f.listFiles()) {
            ol(lf);
        }
    }

    public void pathDemo() {
        ol("----------path:");
        /*
         * File f1 = new File("wei.txt");
         * try { ol(f1.createNewFile()); }
         * catch (IOException ex) { ol(ex.getMessage()); }
         */
        File f2 = new File("src\\wei.txt");
        try {
            ol(f2.createNewFile());
        } catch (IOException ex) {
            ol(ex.getMessage());
        }
    }

    // 遍历，目录中的所有文件
    public void traversal(File f) {
        if (f.exists()) {
            if (f.isFile()) {
                ol(f);
            } else {
                for (File lf : f.listFiles()) {
                    traversal(lf);
                }
            }
        }
    }
}
