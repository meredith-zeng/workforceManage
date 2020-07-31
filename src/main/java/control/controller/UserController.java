package control.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import control.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Log logger = LogFactory.getLog(UserController.class);
    @Autowired
    public UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam Integer userId,@RequestParam String userPassword, HttpSession session, Model model) {
        if (userService.login(userId,userPassword)) {
            logger.info("成功");
            session.setAttribute("userId",userId);
            return "/employee/manageEmployee";
        } else {
            logger.info("失败了呢，阿曾嘤嘤嘤");
            model.addAttribute("messageError", "用户名或密码错误");
            return "/login/login_false";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model){
        session.invalidate();
        return "login/logout";
    }
}
