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
package jdm.base.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import jdm.utils.demo.AbstractDemo;


/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class SendDemo extends AbstractDemo {

    public static void main(String[] args) {
        SendDemo send = new SendDemo();
        send.index();
    }

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        // 创建UDP Socket；
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
        } catch (SocketException ex) {
            ol(ex.getMessage());
        }

        // 待发送的数据；
        byte[] by = "hello world".getBytes();

        // 待发送的数据包；
        DatagramPacket dp = null;

        try {
            dp = new DatagramPacket(by, by.length, InetAddress.getByName("192.168.1.2"), 10001);
        } catch (UnknownHostException ex) {
            ol(ex.getMessage());
        }

        if (ds != null) {
            try {
                ds.send(dp);
                ol("发送方已发送数据，请查收！");
            } catch (IOException ex) {
                ol(ex.getMessage());
            }
            ds.close();
        }
    }

}
