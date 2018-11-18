package cn.peyton.spring.lemon.controller.usergroup;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.def.BaseUser;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.constant.UserType;
import cn.peyton.spring.permission.param.CategoryParam;
import cn.peyton.spring.permission.service.SysCategoryService;
import cn.peyton.spring.permission.service.adapter.CategoryAdapter;
import cn.peyton.spring.usergroup.entity.SysAdmin;
import cn.peyton.spring.usergroup.param.EmployeeParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

import static cn.peyton.spring.common.RequestHolder.getCurrentUser;

/**
 * <h3>管理员 Controller 类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/18 16:13
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Controller
public class AdminController {
    @Resource
    private SysCategoryService sysCategoryService;

    @RequestMapping("/signin-emp.page")
    public ModelAndView change() {
        return new ModelAndView("signin-emp");
    }

    @RequestMapping("/admin/index.page")
    public ModelAndView index(HttpServletRequest request) {
        BaseUser baseUser = RequestHolder.getCurrentUser();
        String type = baseUser.getUserType();
        if (UserType.EMPLOYEE.getValue().equals(type)){
            request.setAttribute("username",baseUser.getUserName());
        }else if (UserType.ADMIN.getValue().equals(type)){
            request.setAttribute("username",baseUser.getUserName());
        }
        return new ModelAndView("perm/admin");
    }

    @ResponseBody
    @RequestMapping("/sys/admin/categories.json")
    public JsonData categories() {
        BaseUser baseUser = getCurrentUser();
        String type = baseUser.getUserType();
        List<CategoryParam> categories = sysCategoryService.findByCategory( UserType.getNumber(type));
        LinkedList<CategoryParam> categoryLinkedList = CategoryAdapter.convert(categories);
        return JsonData.success(categoryLinkedList);
    }
}
