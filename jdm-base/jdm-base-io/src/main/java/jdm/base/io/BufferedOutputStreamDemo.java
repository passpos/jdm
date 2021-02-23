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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import jdm.core.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class BufferedOutputStreamDemo extends AbstractDemo {

    private FileOutputStream fos = null;

    @Override
    public void index() {
        setFos();
        baseDemo();
    }

    public void setFos() {
        String path = "src\\main\\java\\img\\68.txt";
        File file = new File(path);
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            ol(ex.getMessage());
        }
    }

    public void baseDemo() {
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        try {
            bos.write("BufferedOutputStream：hello".getBytes());
            bos.close();
        } catch (IOException ex) {
            ol(ex.getMessage());
        }
    }
}
