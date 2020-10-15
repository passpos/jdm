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
public class TestIt {
    public static void main(String[] args) {
        RepositoryDemo rd = new RepositoryDemo();

        ProducerDemo pd = new ProducerDemo(rd);
        ConsumerDemo cd = new ConsumerDemo(rd);

        Thread t1 = new Thread(pd);
        Thread t2 = new Thread(cd);

        t1.start();
        t2.start();
    }
}
