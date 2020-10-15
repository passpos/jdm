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
package jdm.base.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jdm.utils.demo.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class SimDateFormateDemo extends AbstractDemo {

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        formateDate();
        System.out.println("-------------------");
        parseDate();
    }

    public void formateDate() {
        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String dateStr1 = sdf1.format(date);
        String dateStr2 = sdf2.format(date);
        System.out.println(dateStr1);
        System.out.println(dateStr2);
    }

    public void parseDate() {
        String str1 = "2020年01月10日 20:30:00";
        String str2 = "2020-01-10 20:30:00";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            Date date1 = sdf.parse(str1);
            System.out.println(date1);

            // 这里将报异常，因为SimpleDateFormat要求的日期个是我我们提供给他的日期格式不匹配；
            Date date2 = sdf.parse(str2);
            System.out.println(date2);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
