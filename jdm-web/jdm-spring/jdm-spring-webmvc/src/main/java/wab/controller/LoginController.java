/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wab.controller;

import entity.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import repo.UserRepo;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@Controller
public class LoginController {

    private List<User> list;

    public LoginController() {
        list = new UserRepo().getUsers();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("login");
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest req, String name, Integer age) {
        User tmp = new User(0, name, age);
        if (list.contains(tmp)) {
            req.getSession().setAttribute("name", name);
            req.getSession().setAttribute("age", age);
            return "redirect:upload";
        } else {
            return "redirect:login";
        }
    }
}
