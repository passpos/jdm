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
package jdm.base.util.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import jdm.utils.demo.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class StreamDemo extends AbstractDemo {

    private static StreamDemo sd;
    private ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        sd = new StreamDemo();
        sd.index();
    }

    public void index() {
        baseDemo();
        limitStream();
        skipStream();
        concatStream();
        mapStream();
    }

    public void baseDemo() {
        list.add("abc");
        list.add("def");
        list.add("aghi");
        list.add("jkl");
        list.add("amno");
        list.add("apqr");
        list.add("astu");
        list.add("avwx");
        list.add("ayz");
        list.stream()
                .filter(s -> s.startsWith("a"))
                .filter(s -> s.length() == 3)
                .forEach(s -> ol(s));
    }

    public void createStreamDemo() {
        Stream<String> listStream = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> setStream = set.stream();

        Map<String, Integer> map = new HashMap<>();
        Stream<String> mapKeyStream = map.keySet().stream();
        Stream<Integer> mapValueStream = map.values().stream();

        // 所有键值对对象的集合：
        Stream<Map.Entry<String, Integer>> mapEntrySetStream = map.entrySet().stream();

        String[] strArr = {};
        Stream<String> strArrStream = Stream.of(strArr);
        Stream<String> strDynamicStream = Stream.of("hello", "world");
    }

    public void limitStream() {
        ol("限制为前3个：");
        list.stream().limit(3).forEach(AbstractDemo::ol);
    }

    public void skipStream() {
        ol("跳过前2个：");
        list.stream().skip(2).forEach(AbstractDemo::ol);
    }

    public void concatStream() {
        ol("合并前两个流：");
        Stream<String> s1 = list.stream().limit(3);
        Stream<String> s2 = list.stream().skip(2);
        Stream<String> s3 = Stream.concat(s1, s2);
        s3.forEach(AbstractDemo::ol);

        ol("去重后：");
        Stream<String> s4 = list.stream().limit(3);
        Stream<String> s5 = list.stream().skip(2);
        Stream<String> s6 = Stream.concat(s4, s5);
        s6.distinct().forEach(AbstractDemo::ol);
    }

    public void mapStream() {
        ol("对流的元素进行指定（Function接口）的处理（字符串转整型）：");
        ArrayList<String> l = new ArrayList<>();
        l.add("1514");
        l.add("587");
        l.add("55");
        l.add("15");
        l.stream().map(Integer::parseInt).forEach(AbstractDemo::ol);

        ol("对流的元素进行指定（Function接口）的处理（转整型并求和）：");
        int sum = l.stream().mapToInt(Integer::parseInt).sum();
        ol(sum);
    }

    public void collectStream() {
        List<String> collect = list.stream().skip(3).collect(Collectors.toList());

    }
}
