/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wab.controller;

import entity.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * JSON数据接口
 *
 * @author passpos <paiap@outlook.com>
 */
@Controller
public class JsonController {

    @RequestMapping("json01")
    public User json01() {
        User user = new User(2, "老王", 56);
        return user;
    }

    @RequestMapping("json02")
    @ResponseBody
    public User json02() {
        User user = new User(2, "老王", 56);
        return user;
    }

    @RequestMapping("json03")
    @ResponseBody
    public List<User> json03() {
        ArrayList<User> list = new ArrayList<>();
        User user1 = new User(2, "老王", 56);
        list.add(user1);
        User user2 = new User(3, "老李", 54);
        list.add(user2);
        User user3 = new User(4, "老刘", 57);
        list.add(user3);
        return list;
    }

    @RequestMapping(value = "json04", method = RequestMethod.POST)
    @ResponseBody
    public User json04(String name, int age) {
        User user = new User(2, name, age);
        return user;
    }

    @RequestMapping(value = "json05")
    @ResponseBody
    public String json05() {
        return "json05";
    }

    @RequestMapping(value = "json06")
    @ResponseBody
    public User json06(User user) {
        return user;
    }

    @RequestMapping(value = "json07")
    @ResponseBody
    public User json07(@RequestBody User user) {
        return user;
    }
}
