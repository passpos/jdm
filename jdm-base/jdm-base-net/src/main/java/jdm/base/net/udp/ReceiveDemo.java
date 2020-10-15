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
import java.net.SocketException;
import jdm.utils.demo.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ReceiveDemo extends AbstractDemo {

    public static void main(String[] args) {
        ReceiveDemo receive = new ReceiveDemo();
        receive.index();
    }

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(10001);
        } catch (SocketException ex) {
            ol(ex.getMessage());
        }

        // 构建一个用于存储数据的数据包
        byte[] by = new byte[1024];
        DatagramPacket dp = new DatagramPacket(by, by.length);

        // 开始接收数据
        if (ds != null) {
            try {
                ds.receive(dp);
                byte[] datas = dp.getData();
                int dataLength = dp.getLength();
                ol("接收方已收到数据：");
                ol(new String(datas, 0, dataLength));
            } catch (IOException ex) {
                ol(ex.getMessage());
            }
            ds.close();
        }
    }

}
