/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 重定向
 *
 * @author passpos <paiap@outlook.com>
 */
@Controller
public class RedirectController {

    // 重定向到页面（返回ModelAndView）
    @RequestMapping(value = "/redirect01", method = RequestMethod.GET)
    public ModelAndView redirect01() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:index.jsp");
        return mav;
    }

    // 重定向到页面（直接返回视图名称字符串）
    @RequestMapping(value = "/redirect02", method = RequestMethod.GET)
    public String redirect02() {
        return "redirect:index.jsp";
    }

    // 重定向到路由（以及对应的控制器方法，返回ModelAndView）
    @RequestMapping(value = "/redirect03", method = RequestMethod.GET)
    public ModelAndView redirect03() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:first");
        return mav;
    }

    // 重定向到路由（以及对应的控制器方法，返回视图名称字符串）
    @RequestMapping(value = "/redirect04", method = RequestMethod.GET)
    public String redirect04() {
        return "redirect:first";
    }

    // 重定向到页面，并传递参数
    @RequestMapping(value = "/redirect05", method = RequestMethod.GET)
    public String redirect05() {
        return "redirect:redirect.jsp"
                + "?para=重定向传递参数"
                + "&name=老王"
                + "&age=50";
    }

    // 重定向到页面，并传递中文参数
    @RequestMapping(value = "/redirect06", method = RequestMethod.GET)
    public String redirect06(RedirectAttributes ra) {
        ra.addAttribute("para", "重定向传递参数");
        ra.addAttribute("name", "老王");
        ra.addAttribute("age", "50");
        return "redirect:redirect.jsp";
    }
}
