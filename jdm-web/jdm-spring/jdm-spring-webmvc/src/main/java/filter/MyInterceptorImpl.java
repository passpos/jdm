/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class MyInterceptorImpl implements HandlerInterceptor {

    /**
     * 在目标方法（Handler）执行前执行
     *
     * @param request
     * @param response
     * @param handler
     * @return true: 继续执行目标方法
     *         false: 不再执行目标方法
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptorImpl->preHandler()");
        return true;
    }

    /**
     * 在目标方法（Handler）执行后，视图生成前，执行
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptorImpl->postHandle()");
    }

    /**
     * 在目标方法（Handler）执行后，视图生成后，执行
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptorImpl->afterCompletion()");
    }

}
