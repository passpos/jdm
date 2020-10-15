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
package jdm.base.util.function.samples.consumer;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class RepositoryDemo {

    private int usefulData;

    private boolean state = false;

    /**
     * Get the value of state
     *
     * @return the value of state
     */
    public boolean isState() {
        return state;
    }

    /**
     * Set the value of state
     *
     * @param state new value of state
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * Get the value of usefulData
     *
     * 由消费者调用，位于消费者线程中；
     */
    public synchronized void getUsefulData() {
        if (!state) {
            try {
                wait(); // 令消费者线程等待，生产者线程获得执行权，切入生产者线程；
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("将要消费数据：" + usefulData);

        state = false;

        // 唤醒等待生产的线程；
        notifyAll();
    }

    /**
     * Set the value of usefulData
     *
     * 由生产者调用，位于生产者线程中
     *
     * @param usefulData new value of usefulData
     */
    public synchronized void setUsefulData(int usefulData) {
        if (state) {
            try {
                wait(); // 令生产者前线程等待，消费者线程获得执行权；
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        this.usefulData = usefulData;
        System.out.println("生产了数据：" + this.usefulData);

        state = true;

        // 唤醒等待消费的线程；
        notifyAll();
    }

}
