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
package jdm.base.util.function;

import java.util.function.Predicate;
import jdm.core.AbstractDemo;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class PredicateDemo extends AbstractDemo {

    public static void main(String[] args) {
        PredicateDemo demo = new PredicateDemo();
        demo.index();
    }

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        boolean isOK = checkString("hello world", s -> s.length() > 8);
        ol("isOK：" + isOK);

        boolean isNotOK = checkStringNegate("hello world", s -> s.length() > 8);
        ol("isNotOK：" + isNotOK);

        boolean isAndOK = checkStringAnd(
                "hello world",
                s -> s.length() > 8,
                s -> s.length() < 15
        );
        ol("isAndOK：" + isAndOK);

        boolean isOrOK = checkStringOr(
                "hello world", // 11个字符
                s -> s.length() > 8,
                s -> s.length() < 10
        );
        ol("isOrOK：" + isOrOK);

    }

    /**
     * 判断字符串是否满足指定的条件（由lambda表达式指定）
     * @param s
     * @param p
     * @return
     */
    public boolean checkString(String s, Predicate<String> p) {
        return p.test(s);
    }

    /**
     * 判断字符串是否满足指定的条件（由lambda表达式指定），返回否定结果
     * @param s
     * @param p
     * @return
     */
    public boolean checkStringNegate(String s, Predicate<String> p) {
        return p.negate().test(s);
    }

    /**
     * 使用两个判断条件（由lambda表达式指定），返回两个判断结果的逻辑与
     * @param s
     * @param p1
     * @param p2
     * @return
     */
    public boolean checkStringAnd(String s, Predicate<String> p1, Predicate<String> p2) {
        return p1.and(p2).test(s);
    }

    /**
     * 使用两个判断条件（由lambda表达式指定），返回两个判断结果的逻辑与
     * @param s
     * @param p1
     * @param p2
     * @return
     */
    public boolean checkStringOr(String s, Predicate<String> p1, Predicate<String> p2) {
        return p1.or(p2).test(s);
    }

    public void method() {

    }
}
