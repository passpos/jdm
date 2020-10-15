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
package lang.samples.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 关于多线程的启动方式：
 * 不要通过run()方法去启动，而是通过start()方法；
 * start()方法会告诉虚拟机，由虚拟机调用run()方法；
 *
 * ByExtendsThread demo1 = new ByExtendsThread("旺财");
 * ByExtendsThread demo2 = new ByExtendsThread("小强");
 *
 * demo1.setDaemon(true);
 *
 * demo1.start();
 * demo2.start();
 *
 * @author realpai <paiap@outlook.com>
 */
public class ByExtendsThread extends Thread {

    public ByExtendsThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("输出：" + i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ByExtendsThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("线程名称,this.getName()：" + this.getName());
        System.out.println("线程名称，Thread.currentThread().getName()：" + Thread.currentThread().getName());
    }

}
