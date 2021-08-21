/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wab.controller.excep;

import exception.BussinessException;
import exception.ParamsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@Controller
public class ExcepController {

    @RequestMapping("excep01")
    @ResponseBody
    public String excep01() {
        int v = 1 / 0;
        return "异常处理演示";
    }

    @RequestMapping("excep02")
    @ResponseBody
    public String excep02() {
        if (true) {
            throw new ParamsException();
        }
        return "异常处理演示";
    }

    @RequestMapping("excep03")
    @ResponseBody
    public String excep03() {
        if (true) {
            throw new BussinessException();
        }
        return "异常处理演示";
    }
}
