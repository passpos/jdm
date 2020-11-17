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
package jdm.base.net.samples.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdm.core.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class SendSample extends AbstractDemo {

    public static void main(String[] args) {
        SendSample client = new SendSample();
        client.index();
    }

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        // 创建连接
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
        } catch (SocketException ex) {
            ol(ex.getMessage());
        }

        // 从系统输入录入数据；
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = null;

        try {
            // 赋值语句写在循环条件中，这样每次都是先执行赋值后面的表达式。
            // 这样，额外的程序可以参与控制循环。而不是直接拿取固定的值，那样就成了死循环；
            while ((inputStr = br.readLine()) != null) {
                if ("886".equals(inputStr)) {
                    break;
                }

                // 待发送的数据包；
                byte[] by = inputStr.getBytes();
                DatagramPacket dp = null;
                try {
                    dp = new DatagramPacket(
                            by,
                            by.length,
                            InetAddress.getByName("192.168.1.2"),
                            5000
                    );
                } catch (UnknownHostException ex) {
                    ol(ex.getMessage());
                }

                // 开始发送
                if (ds != null) {
                    try {
                        ds.send(dp);
                    } catch (IOException ex) {
                        ol(ex.getMessage());
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SendSample.class.getName()).log(Level.SEVERE, null, ex);
        }

        // 关闭连接
        if (ds != null) {
            ds.close();
        }

    }

}
