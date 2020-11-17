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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import jdm.core.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ClientSample extends AbstractDemo {

    public static void main(String[] args) {
        ClientSample cs = new ClientSample();
        cs.index();
    }

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        Socket s;
        try {
            // Socket s = new Socket(InetAddress.getByName("192.168.1.2"), 3000);
            s = new Socket("192.168.1.2", 3000);

            // 从键盘录入数据；
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            String inputStr;
            while ((inputStr = br.readLine()) != null) {
                if ("886".equals(inputStr)) {
                    break;
                }

                // 写到输出流，并发送数据；
                // OutputStream os = s.getOutputStream();
                // os.write(inputStr.getBytes());
                // 发送数据；
                bw.write(inputStr);
                bw.newLine();
                bw.flush();

                // 接收服务器反馈
                // 如果接收不到服务器反馈，客户端的循环就会卡在这里；
                InputStream is = s.getInputStream();
                byte[] by = new byte[1024];
                String str = new String(by, 0, is.read(by));
                ol(str);
            }

            // os.close();
            // is.close();
            br.close();
            s.close();
        } catch (UnknownHostException ex) {
            ol(ex.getMessage());
        } catch (IOException ex) {
            ol(ex.getMessage());
        }
    }
}
