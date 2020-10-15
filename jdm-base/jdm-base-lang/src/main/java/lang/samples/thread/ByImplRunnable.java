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

/**
 * ByImplRunnable bir = new ByImplRunnable();
 * Thread t1 = new Thread(bir);
 * Thread t2 = new Thread(bir, "threadName");
 * Thread t3 = new Thread(bir);
 *
 * t1.start();
 * t2.start();
 * t3.start();
 *
 * @author realpai <paiap@outlook.com>
 */
public class ByImplRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("输出：" + i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(
                "线程名称，Thread.currentThread().getName()："
                + Thread.currentThread().getName());
    }

}
