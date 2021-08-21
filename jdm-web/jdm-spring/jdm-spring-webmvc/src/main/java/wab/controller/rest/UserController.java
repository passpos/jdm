/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wab.controller.rest;

import entity.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import repo.UserRepo;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@Controller
@RequestMapping("user")
public class UserController {

    private UserRepo repo;

    public UserController() {
        repo = new UserRepo();
    }

    @RequestMapping("{id}")
    @ResponseBody
    public User findOne(@PathVariable Integer id) {
        User user = repo.getUserById(id);
        return user;
    }

    @PostMapping("")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        repo.addUser(user);
        return user;
    }

    @GetMapping("{id}")
    @ResponseBody
    public User findById(@PathVariable int id) {
        User user = repo.getUserById(id);
        return user;
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public Map<String, String> deleteById(@PathVariable int id) {
        int res = repo.deleteUserById(id);
        Map<String, String> map = new HashMap<>();
        if (res == 0) {
            map.put("msg", "删除失败");
        } else {
            map.put("msg", "删除成功");
        }
        return map;
    }

}
