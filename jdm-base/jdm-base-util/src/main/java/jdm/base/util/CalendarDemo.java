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
package jdm.base.util;

import java.util.Calendar;
import jdm.utils.demo.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class CalendarDemo extends AbstractDemo {

    private Calendar cald;

    @Override
    public void index() {
        cald = Calendar.getInstance();

        baseDemo();

        System.out.println("--------");
        getCald();
        setCald();
    }

    public void baseDemo() {
        System.out.println(cald);
        int year = cald.get(Calendar.YEAR);
        int month = cald.get(Calendar.MONTH) + 1;
        int day = cald.get(Calendar.DATE);
        // Month是从0开始
        System.out.println(year + "年" + month + "月" + day + "日");
    }

    public void getCald() {
        cald.add(Calendar.YEAR, 30);
        System.out.println("上午：" + Calendar.AM);
        System.out.println("下午：" + Calendar.PM);
        System.out.println("年：" + Calendar.YEAR);
        System.out.println("月：" + Calendar.MONTH);
        System.out.println("日：" + Calendar.DATE);
        System.out.println("cald.get(Calendar.YEAR)：" + cald.get(Calendar.YEAR));
    }

    public void setCald() {
        cald.set(2020, 1, 11);
        int year = cald.get(Calendar.YEAR);
        int month = cald.get(Calendar.MONTH);
        int day = cald.get(Calendar.DATE);
        // Month是从0开始
        System.out.println(year + "年" + month + "月" + day + "日");
    }
}
