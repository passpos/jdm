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

/**
 * 在控制器上也可以使用“@ResponseBody”或“@RESTController”注解，
 * 这样就可以省去控制器中所有方法前的“@ResponseBody”注解；
 *
 * @author passpos <paiap@outlook.com>
 */
@Controller
@RequestMapping("/api")
public class FirstController {

    /**
     * 方法的 @RequestMapping 注解不能缺省。
     *
     * @return
     */
    @RequestMapping("/first")
    public ModelAndView first() {
        System.out.println("开始执行：FirstController->first()");
        ModelAndView mav = new ModelAndView();

        /* 设置模型对象
         *
         * 参数1是传递给视图的变量名；
         * 参数2是值；
         */
        mav.addObject("first", "我的第一个基于SpringMVC的页面！");

        /* 设置视图对象
         * 参数：视图文件名；
         */
        mav.setViewName("first");
        // mav.setView("first");

        System.out.println("即将返回视图：FirstController->first()");
        return mav;
    }

    @RequestMapping(value = "/method", method = RequestMethod.GET)
    public ModelAndView mapMethod() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("first", "方法映射");
        mav.setViewName("first");
        return mav;
    }

}
