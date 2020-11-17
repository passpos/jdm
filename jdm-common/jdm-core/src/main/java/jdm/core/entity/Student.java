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
package jdm.core.entity;

import java.util.Objects;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class Student {

    private int sid;
    private String name;
    private int age;
    private String address;

    public Student() {
    }

    public Student(int sid, String name, int age, String address) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.address = address;
    }


    /**
     * Get the value of sid
     *
     * @return the value of sid
     */
    public int getSid() {
        return sid;
    }

    /**
     * Set the value of sid
     *
     * @param sid new value of sid
     */
    public void setSid(int sid) {
        this.sid = sid;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of age
     *
     * @return the value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the value of age
     *
     * @param age new value of age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "sid=" + sid + ", name=" + name + ", age=" + age + ", address=" + address + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.sid;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + this.age;
        hash = 37 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.sid != other.sid) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

}
