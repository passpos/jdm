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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import jdm.core.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class MapDemo extends AbstractDemo {

    Map<String, String> map;

    @Override
    public void index() {
        baseDemo();
        method01();
        method02();
        method03();
        destroy();
    }

    public void baseDemo() {
        map = new HashMap<>();
        map.put("第1句", "hello");
        map.put("第2句", "world");
        map.put("第3句", "java");

        ol(map);
    }

    public void method01() {
        map.put("a", "chdsb");
        ol(map);

        ol(map.size());

        ol(map.containsKey("第1句"));
        ol(map.containsValue("java"));

    }

    public void method02() {
        ol("----------Map的获取方法：");
        ol(map.get("第2句"));
        ol(map.get("第1句"));

        Set<String> ks = map.keySet();
        for (String k : ks) {
            ol(k);
        }

        Collection<String> values = map.values();
        for (String v : values) {
            ol(v);
        }

    }

    public void method03() {
        ol("----------遍历集合：");
        Set<String> ks = map.keySet();
        for (String k : ks) {
            String v = map.get(k);
            ol(k + "是" + v);
        }

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            ol("直接输出：" + entry);
            ol("通过entrySet：" + entry.getKey() + "的值是" + entry.getValue());
        }
    }

    public void destroy() {

        map.remove("a");
        ol(map);

        map.remove("第1句", "hello");
        ol(map);

        map.clear();
        ol(map);
        ol(map.isEmpty());
    }
}
