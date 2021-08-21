/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wab.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 请求转发
 *
 * @author passpos <paiap@outlook.com>
 */
@Controller
public class ForwardController {

    @RequestMapping(value = "/forward01", method = RequestMethod.GET)
    public ModelAndView forward01() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("forward:first");
        return mav;
    }

    @RequestMapping(value = "/forward02", method = RequestMethod.GET)
    public String forward02() {
        return "forward:first";
    }

    /**
     * 这种方式访问的是视图配置目录下的视图，而不是站点根目录下的资源；
     *
     * @return
     */
    @RequestMapping(value = "/forward03", method = RequestMethod.GET)
    public String forward03() {
        return "first";
    }

    @RequestMapping(value = "/forward04", method = RequestMethod.GET)
    public String forward04(HttpServletRequest request) {
        request.setAttribute("first", "请求转发");
        return "first";
    }
}
