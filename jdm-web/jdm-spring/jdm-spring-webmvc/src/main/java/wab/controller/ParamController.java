/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wab.controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@Controller
public class ParamController {

    @RequestMapping(value = "/params01", method = RequestMethod.GET)
    public ModelAndView params01(String name, int age) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("params", "接收路由参数！");
        mav.addObject("name", name);
        mav.addObject("age", age);
        mav.setViewName("route/params");
        return mav;
    }

    @RequestMapping(value = "/params02", method = RequestMethod.GET)
    public ModelAndView params02(
            @RequestParam(defaultValue = "老王") String name,
            @RequestParam(defaultValue = "50") int age) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("params", "接收路由参数！");
        mav.addObject("name", name);
        mav.addObject("age", age);
        mav.setViewName("route/params");
        return mav;
    }

    @RequestMapping(value = "/params03", method = RequestMethod.GET)
    public ModelAndView params03(
            @RequestParam(defaultValue = "老王", name = "nick") String name,
            @RequestParam(defaultValue = "50") int age) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("params", "接收路由参数！");
        mav.addObject("name", name);
        mav.addObject("age", age);
        mav.setViewName("route/params");
        return mav;
    }

    @RequestMapping(value = "/params04", method = RequestMethod.GET)
    public ModelAndView params04(User user) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("params", "接收Bean类型路由参数！");
        mav.addObject("name", user.getName());
        mav.addObject("age", user.getAge());
        mav.setViewName("route/params");
        return mav;
    }
}
