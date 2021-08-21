/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wab;

import exception.BussinessException;
import exception.ParamsException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@Component
public class CustomException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView mav = new ModelAndView("error");
        mav.addObject("ex", "默认异常");

        if (ex instanceof ParamsException) {
            mav.setViewName("exception/params_error");
            mav.addObject("msg", ((ParamsException) ex).getMsg());
        }

        if (ex instanceof BussinessException) {
            mav.setViewName("exception/buss_error");
            mav.addObject("msg", ((BussinessException) ex).getMsg());
        }
        return mav;
    }

}
