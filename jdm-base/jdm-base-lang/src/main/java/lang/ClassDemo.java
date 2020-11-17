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
package lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import jdm.core.AbstractDemo;
import utils.entity.demo.sample.Person;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ClassDemo extends AbstractDemo {

    Class<Person> person = Person.class;

    public static void main(String[] args) {
        ClassDemo cd = new ClassDemo();
        cd.index();

        try {
            cd.getConstructor();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | IllegalArgumentException | InvocationTargetException ex) {
            ol(ex.getMessage());
        }

        try {
            cd.getField();
        } catch (NoSuchFieldException ex) {
            ol(ex.getMessage());
        }

        cd.getMethod();
    }

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        Class<ClassDemo> ac1 = ClassDemo.class;
        ol(ac1);

        Class<? extends ClassDemo> ac2 = this.getClass();
        ol(ac2);

        try {
            Class<?> ac3 = Class.forName("lang.ClassDemo");
            ol(ac3);
        } catch (ClassNotFoundException ex) {
            ol(ex.getMessage());
        }
    }

    public void getConstructor() throws NoSuchMethodException, IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Class<ClassDemo> ac = ClassDemo.class;

        ol("----------获取类的公共构造方法：");
        Constructor<?>[] cstr1 = ac.getConstructors();
        for (Constructor<?> constructor : cstr1) {
            ol(constructor);
        }

        ol("----------获取类的所有已声明的构造方法：");
        Constructor<?>[] cstr2 = ac.getDeclaredConstructors();
        for (Constructor<?> constructor : cstr2) {
            ol(constructor);
        }

        ol("----------获取指定的类的构造方法（空参），并据此创建对象：");
        Constructor<ClassDemo> cstr3 = ac.getConstructor();
        ClassDemo newInst = cstr3.newInstance();
        ol(newInst);

        ol("----------获取指定的类的构造方法（多参数），并据此创建对象：");
        Constructor<Person> cstr4 = person.getConstructor(String.class, int.class);
        Person stu = cstr4.newInstance("任我行", 55);
        ol(stu);
    }

    public void getField() throws NoSuchFieldException {
        ol("----------公有成员变量：");
        Field[] dfs1 = person.getFields();
        for (Field df : dfs1) {
            ol(df);
        }

        ol("----------所有成员变量：");
        Field[] dfs2 = person.getDeclaredFields();
        for (Field df : dfs2) {
            ol(df);
        }

        ol("----------指定成员变量：");
        Field f = person.getField("name");
        ol(f);
    }

    public void getMethod() {
        ol("----------公有成员方法：");
        Method[] methods = person.getMethods();
        for (Method method : methods) {
            ol(method);
        }
    }

}
