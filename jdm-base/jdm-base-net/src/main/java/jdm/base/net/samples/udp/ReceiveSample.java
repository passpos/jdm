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

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import jdm.core.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ReceiveSample extends AbstractDemo {

    public static void main(String[] args) {
        ReceiveSample server = new ReceiveSample();
        server.index();
    }

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(5000);
        } catch (SocketException ex) {
            ol(ex.getMessage());
        }

        // 这里的循环虽然是死循环，
        // 但是这里的连接只有不断接收到发送端发来的数据，循环才会继续下去；
        while (true) {
            byte[] by = new byte[1024];
            DatagramPacket dp = new DatagramPacket(by, by.length);

            if (ds != null) {
                try {
                    ds.receive(dp);
                    ol("接受到数据：" + new String(dp.getData(), 0, dp.getLength()));
                    // ds.close();
                } catch (IOException ex) {
                    ol(ex.getMessage());
                }
            }
        }

    }

}
