package cn.peyton.spring.lemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h3>用户 Controller 类[用于登录等]</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/18 15:31
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Controller
public final class PortalController {

    /**
     * <h4>主页面进入方法 index [首页]</h4>
     *
     * @return
     */
    @RequestMapping(value = {"/", "/index.page"})
    public ModelAndView index() {
        return new ModelAndView("index-portal");
    }

    @RequestMapping("/regchanagesuccess.json")
    public ModelAndView cusRegister(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("titleMessage", "会员注册成功");
        request.setAttribute("requestPath", "/sign-in-cus.page?type=1");

        return new ModelAndView("success");
    }

    @RequestMapping("/test-cus-manager.page")
    public ModelAndView testCusManage() {
        return new ModelAndView("cus/cus");
    }
}
