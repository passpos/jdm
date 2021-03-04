package wab.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wab.entity.User;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@RequestMapping("/api")
@Controller
public class HelloHandler {

    /**
     * 此时应该访问的URI：/api/index
     *
     * @return
     */
    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/user")
    @ResponseBody
    public User getUser() {
        User user = new User(1, "匣中剑", 27);
        return user;
    }
}