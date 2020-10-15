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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import jdm.utils.demo.AbstractDemo;


/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ServerThreadSample extends AbstractDemo implements Runnable {

    protected Socket s;

    ServerThreadSample(Socket s) {
        this.s = s;
    }

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {

    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            int count = 0;
            File f = new File(count + ".txt");
            while (f.exists()) {
                count++;
                f = new File(count + ".txt");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            String str;
            while ((str = br.readLine()) != null) {
                // 打印数据；
                ol(str);

                // 写入文件；
                bw.write(str);
                bw.newLine();
                bw.flush();

                // 向客户端发送反馈信息；
                OutputStream os = s.getOutputStream();
                os.write("OK".getBytes());
            }
            // 取得输入流和接收数据；
            // InputStream is = s.getInputStream();
            // byte[] by = new byte[1024];
            // String str = new String(by, 0, is.read(by));
            // 关闭文件缓冲写入流；
            bw.close();

            // 关闭Socket；
            s.close();
        } catch (IOException ex) {
            ol(ex.getMessage());
        }
    }
}
