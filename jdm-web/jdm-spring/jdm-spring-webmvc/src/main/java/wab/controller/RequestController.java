/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wab.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 请求域
 *
 * @author passpos <paiap@outlook.com>
 */
@Controller
public class RequestController {

    @RequestMapping(value = "/request01", method = RequestMethod.GET)
    public ModelAndView request01(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "请求域01");
        mav.setViewName("request");
        return mav;
    }

    @RequestMapping(value = "/request02", method = RequestMethod.GET)
    public String request02(HttpServletRequest request) {
        request.setAttribute("msg", "请求域02");
        return "request";
    }

    @RequestMapping(value = "/request03", method = RequestMethod.GET)
    public String request03(Model model) {
        model.addAttribute("msg", "请求域03");
        return "request";
    }

    @RequestMapping(value = "/request04", method = RequestMethod.GET)
    public String request04(ModelMap mm) {
        mm.addAttribute("msg", "请求域04");
        return "request";
    }

    @RequestMapping(value = "/request05", method = RequestMethod.GET)
    public String request05(Map<String, String> map) {
        map.put("msg", "请求域05");
        return "request";
    }
}
