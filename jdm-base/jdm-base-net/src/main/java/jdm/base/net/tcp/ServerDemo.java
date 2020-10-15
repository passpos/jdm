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
package jdm.base.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import jdm.utils.demo.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ServerDemo extends AbstractDemo {

    public static void main(String[] args) {
        ServerDemo sd = new ServerDemo();
        sd.index();
    }

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        ServerSocket ss;
        try {
            ss = new ServerSocket(3000);

            // 开始侦听端口；
            Socket s = ss.accept();

            // 取得输入流和接收数据；
            InputStream is = s.getInputStream();
            byte[] by = new byte[1024];
            String str = new String(by, 0, is.read(by));

            // 打印数据；
            ol(str);

            // 关闭Socket与ServerSocket；
            s.close();
            ss.close();
        } catch (IOException ex) {
            ol(ex.getMessage());
        }
    }

}
