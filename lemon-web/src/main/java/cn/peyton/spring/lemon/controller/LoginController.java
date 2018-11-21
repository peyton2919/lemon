package cn.peyton.spring.lemon.controller;

import cn.peyton.spring.cipher.Md5Util;
import cn.peyton.spring.constant.Constants;
import cn.peyton.spring.constant.Numerical;
import cn.peyton.spring.def.BaseUser;
import cn.peyton.spring.inf.IUser;
import cn.peyton.spring.usergroup.entity.SysAdmin;
import cn.peyton.spring.usergroup.param.AdminParam;
import cn.peyton.spring.usergroup.param.EmployeeParam;
import cn.peyton.spring.usergroup.service.SysAdminService;
import cn.peyton.spring.usergroup.service.SysEmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <h3>登录 Controller 类 .</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.lemon.controller.common.LoginController.java
 * @createDate: 2018/9/20 13:19
 * @version: 1.0.0
 * </pre>
 */
@Controller
public final class LoginController {

    private static final String PATH_EMP = "/sign-in-emp.page";
    private static final String PATH_CUS = "/sign-in-cus.page";
    private static final String PATH_SUP = "/sign-in-sup.page";

    @Resource
    private SysAdminService sysAdminService;
    @Resource
    private SysEmployeeService sysEmployeeService;
//    @Resource
//    private SupplierService supplierInfoService;
//    @Resource
//    private CustomerService customerInfoService;

    @RequestMapping("/sign-in-emp.page")
    public ModelAndView signinEmp() {
        return new ModelAndView("signin-emp");
    }

    @RequestMapping("/sign-in-sup.page")
    public ModelAndView signinSup(String type, HttpServletRequest request) {
        request.setAttribute("type",type);
        return new ModelAndView("sign-in");
    }

    @RequestMapping("/sign-in-cus.page")
    public ModelAndView signinCus(String type, HttpServletRequest request) {
        request.setAttribute("type",type);
        return new ModelAndView("sign-in");
    }

    @RequestMapping("/login-emp.page")
    public void loginEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        StringBuffer errorMsg = new StringBuffer();
        HttpSession session = request.getSession();
        String ret = request.getParameter("ret");
        boolean checkPass = false;
        if (Numerical.STRING_ZERO.equals(type)) {
            EmployeeParam employee = sysEmployeeService.findByKeyword(username);
            checkPass = checked(employee, errorMsg, username, password);
            if (checkPass) {
               session.setAttribute(Constants.CURRENT_USER.name(),employee);
               session.getServletContext().setAttribute(Constants.CURRENT_USER_TYPE.name(),IUser.EMPLOYEE_TYPE_NUM);
            }
        } else if (Numerical.STRING_FIRST.equals(type)) {
            AdminParam admin = sysAdminService.findByKeyword(username);
            checkPass = checked(admin, errorMsg, username, password);
            if (checkPass) {
                session.setAttribute(Constants.CURRENT_USER.name(),admin);
                session.getServletContext().setAttribute(Constants.CURRENT_USER_TYPE.name(), IUser.ADMIN_TYPE_NUM);
            }
        }

        if (checkPass) {
            if (StringUtils.isNotBlank(ret)) {
                response.sendRedirect(ret);
            } else {
                //TODO
                response.sendRedirect("/admin/index.page");
            }
            return;
        }
        request.setAttribute("error", errorMsg);
        request.setAttribute("username", username);
        request.setAttribute("type",type);
        if (StringUtils.isNotBlank(ret)) {
            request.setAttribute("ret", ret);
        }
        request.getRequestDispatcher(PATH_EMP).forward(request,response);
    }

    @RequestMapping("/login.page")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        StringBuffer errorMsg = new StringBuffer();
        HttpSession session = request.getSession();
        String ret = request.getParameter("ret");
        boolean checkPass = false;
        if (Numerical.STRING_SECOND.equals(type)) {
//            SupplierParam param = supplierInfoService.login(username);
//            checkPass = checked(param, errorMsg, username, password);
//            if (checkPass) {
//                session.setAttribute(Constants.CURRENT_USER.name(),param);
//                session.getServletContext().setAttribute(Constants.CURRENT_USER_TYPE.name(),IUser.SUPPLIER_TYPE_NUM);
//            }
        } else if (Numerical.STRING_FIRST.equals(type)) {
//            CustomerParam param = customerInfoService.login(username);
//            checkPass = checked(param, errorMsg, username, password);
//            if (checkPass) {
//                session.setAttribute(Constants.CURRENT_USER.name(),param);
//                session.getServletContext().setAttribute(Constants.CURRENT_USER_TYPE.name(), IUser.CUSTOMER_TYPE_NUM);
//            }
        }

        if (checkPass) {
            if (StringUtils.isNotBlank(ret)) {
                response.sendRedirect(ret);
            } else {
                if (Numerical.STRING_FIRST.equals(type)){
                    //TODO
                    response.sendRedirect("/cus/cus.page");
                }else if (Numerical.STRING_SECOND.equals(type)){
                    //TODO
                    response.sendRedirect("/sup/sup.page");
                }
            }
            return;
        }
        request.setAttribute("error", errorMsg);
        request.setAttribute("username", username);
        request.setAttribute("type",type);
        if (StringUtils.isNotBlank(ret)) {
            request.setAttribute("ret", ret);
        }
        if (Numerical.STRING_FIRST.equals(type)){
            request.getRequestDispatcher(PATH_CUS).forward(request,response);
        }else if (Numerical.STRING_SECOND.equals(type)){
            request.getRequestDispatcher(PATH_SUP).forward(request,response);
        }

    }

    @RequestMapping("/logout.page")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        BaseUser user = (BaseUser)session.getAttribute(Constants.CURRENT_USER.name());
        Integer tId = user.getUserTypeValue();
        session.invalidate();//移除当前Session
        if(IUser.EMPLOYEE_TYPE_NUM.equals(tId) || IUser.ADMIN_TYPE_NUM.equals(tId)){
            response.sendRedirect(PATH_EMP);
        } else if (IUser.SUPPLIER_TYPE_NUM.equals(tId)) {
            response.sendRedirect(PATH_SUP);
        } else if (IUser.CUSTOMER_TYPE_NUM.equals(tId)) {
            response.sendRedirect(PATH_CUS);
        } else {
            response.sendRedirect("/");
        }
    }

    /**
     * <h4>查检</h4>
     * @param obj
     * @param errorMsg
     * @param username
     * @param password
     * @return
     */
    public boolean checked(Object obj,StringBuffer errorMsg,String username,String password) {
        if (StringUtils.isBlank(username)) {
            errorMsg.append("用户名不可以为空");
            return false;
        } else if (StringUtils.isBlank(password)) {
            errorMsg.append("密码不可以为空");
            return false;
        }
        if (null == obj) {
            errorMsg.append("查询不到指定用户");
            return false;
        }
        if (obj instanceof SysAdmin) {
            SysAdmin admin = (SysAdmin) obj;
            if (!admin.getPassword().equals(Md5Util.encrypt(password))) {
                errorMsg.append("管理员名或密码错误");
                return false;
            } else if (!Numerical.FIRST.equals(admin.getStatus())) {
                errorMsg.append("管理员已被冻结");
                return false;
            }
        }
        if (obj instanceof EmployeeParam) {
            EmployeeParam employee = (EmployeeParam) obj;
            String originalPwd = employee.getPwd();
            if (null == originalPwd || "".equals(originalPwd)) {
                errorMsg.append("用户不存在");
                return false;
            }
            existUsernameAndPassword(originalPwd, password, employee.getEncrypt(),
                    errorMsg, employee.getStatus());
        }
//        if (obj instanceof CustomerParam) {
//            CustomerParam param = (CustomerParam) obj;
//            existUsernameAndPassword(param.getPwd(), password, param.getEncrypt(), errorMsg, param.getStatus());
//        }
//        if (obj instanceof SupplierParam) {
//            SupplierParam param = (SupplierParam) obj;
//            existUsernameAndPassword(param.getPwd(), password, param.getEncrypt(), errorMsg, param.getStatus());
//        }
        return true;
    }

    private boolean existUsernameAndPassword(String ePwd,String pwd, String encrypt,StringBuffer errorMsg, Integer status) {
        if (!ePwd.equals(Md5Util.encrypt(pwd, encrypt))) {
            errorMsg.append("用户名或密码错误");
            return false;
        }else if (!Numerical.FIRST.equals(status)) {
            errorMsg.append("用户已被冻结，请联系管理员)");
            return false;
        }
        return true;
    }
}
