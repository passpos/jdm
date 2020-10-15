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
package jdm.base.net.samples.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import jdm.utils.demo.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ServerSample extends AbstractDemo {

    public static void main(String[] args) {
        ServerSample ss = new ServerSample();
        ss.index();
    }

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        ServerSocket ss;
        try {
            ss = new ServerSocket(3000);

            while (true) {
                // 开始侦听端口；
                // 任何对该端口的请求都会被识别,并被获取同时创建一个Socket连接；
                Socket s = ss.accept();
                new Thread(new ServerThreadSample(s)).start();
            }

            // 关闭ServerSocket；
            // ss.close();
        } catch (IOException ex) {
            ol(ex.getMessage());
        }
    }
}
