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
package jdm.base.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdm.utils.demo.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class InetAddressDemo extends AbstractDemo {

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        try {
            InetAddress ia = InetAddress.getByName("DESKTOP-RQ3E460");
            ol(ia.toString());
            ol(ia.getHostAddress());
            ol(ia.getHostName());
        } catch (UnknownHostException ex) {
            Logger.getLogger(InetAddressDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
