package cn.peyton.spring.lemon.controller;

import cn.peyton.spring.cipher.Md5Util;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.constant.Constants;
import cn.peyton.spring.constant.Numerical;
import cn.peyton.spring.def.BaseUser;
import cn.peyton.spring.exception.ValidationException;
import cn.peyton.spring.inf.IUser;
import cn.peyton.spring.usergroup.entity.SysAdmin;
import cn.peyton.spring.usergroup.param.AdminParam;
import cn.peyton.spring.usergroup.param.CustomerParam;
import cn.peyton.spring.usergroup.param.EmployeeParam;
import cn.peyton.spring.usergroup.param.SupplierParam;
import cn.peyton.spring.usergroup.service.CustomerService;
import cn.peyton.spring.usergroup.service.SupplierService;
import cn.peyton.spring.usergroup.service.SysAdminService;
import cn.peyton.spring.usergroup.service.SysEmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

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
    @Resource
    private SupplierService supplierInfoService;
    @Resource
    private CustomerService customerInfoService;

    /**
     * <h4>管理员、员工登录</h4>
     * @param request 请求对象
     * @param response 响应对象
     * @return
     */
    @RequestMapping("/sign-in-emp.page")
    public ModelAndView signInEmp(HttpServletRequest request,HttpServletResponse response) {
        Map<String, String> map = new LinkedHashMap<String, String>(2);
        map.put("0", "员工");
        map.put("1", "管理员");
        request.setAttribute("userTypeMap",map);
        return new ModelAndView("signin-emp");
    }

    /**
     * <h4>客户、供应商登录</h4>
     * @param type 类型 [1 客户 ; 2 供应商]
     * @param request 请求对象
     * @return
     */
    @RequestMapping("/sign-in.page")
    public ModelAndView signIn(String type, HttpServletRequest request) {
        request.setAttribute("type",type);
        return new ModelAndView("sign-in");
    }

    /**
     * <h4>员工登录</h4>
     * @param username 名称
     * @param password 密码
     * @param remember 是否记住用户名称与密码
     * @param type 用户类型 [0 员工 ; 1 管理员]
     * @param request 请求对象
     * @param response 响应对象
     * @return
     */
    @RequestMapping("/login-emp.json")
    @ResponseBody
    public JsonData loginEmployee(String username,String password,String remember,String type,
                                  HttpServletRequest request, HttpServletResponse response) {
        checkedUsernameAndPassword(username,password);
        HttpSession session = request.getSession();
        boolean checkPass = false;
        if (Numerical.STRING_ZERO.equals(type)) {
            EmployeeParam employee = sysEmployeeService.findByKeyword(username);
            checkPass = checked(employee,password);
            if (checkPass) {
                session.setAttribute(Constants.CURRENT_USER.name(),employee);
                session.getServletContext().setAttribute(Constants.CURRENT_USER_TYPE.name(),IUser.EMPLOYEE_TYPE_NUM);
            }
        } else if (Numerical.STRING_FIRST.equals(type)) {
            AdminParam admin = sysAdminService.findByKeyword(username);
            checkPass = checked(admin, password);
            if (checkPass) {
                session.setAttribute(Constants.CURRENT_USER.name(),admin);
                session.getServletContext().setAttribute(Constants.CURRENT_USER_TYPE.name(), IUser.ADMIN_TYPE_NUM);
            }
        }
        return JsonData.success();
    }

    /**
     * <h4>客户、供应商登录 </h4>
     *  @param username 名称
     * @param password 密码
     * @param remember 是否记住用户名称与密码
     * @param type 用户类型 [0 员工 ; 1 管理员]
     * @param request 请求对象
     * @param response 响应对象
     * @return
     */
    @ResponseBody
    @RequestMapping("/login.json")
    public JsonData login(String username,String password,String remember,String type,
                          HttpServletRequest request, HttpServletResponse response) {
        checkedUsernameAndPassword(username,password);
        HttpSession session = request.getSession();
        boolean checkPass = false;
        if (Numerical.STRING_SECOND.equals(type)) {
            SupplierParam param = supplierInfoService.login(username);
            checkPass = checked(param,password);
            if (checkPass) {
                session.setAttribute(Constants.CURRENT_USER.name(),param);
                session.getServletContext().setAttribute(Constants.CURRENT_USER_TYPE.name(),IUser.SUPPLIER_TYPE_NUM);
            }
        } else if (Numerical.STRING_FIRST.equals(type)) {
            CustomerParam param = customerInfoService.login(username);
            checkPass = checked(param,password);
            if (checkPass) {
                session.setAttribute(Constants.CURRENT_USER.name(),param);
                session.getServletContext().setAttribute(Constants.CURRENT_USER_TYPE.name(), IUser.CUSTOMER_TYPE_NUM);
            }
        }
        return JsonData.success();
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

    //================================================ private method ================================================//

    /**
     * <h4>判空用户名称和密码</h4>
     * @param username 用户名称
     * @param password 密码
     */
    private void checkedUsernameAndPassword(String username, String password) {
        if (StringUtils.isBlank(username)) {
            throw new ValidationException("用户名不可以为空");
        } else if (StringUtils.isBlank(password)) {
            throw new ValidationException("密码不可以为空");
        }
    }

    /**
     * <h4>查检</h4>
     * @param obj 要判断的对象
     * @param password 密码
     * @return
     */
    private boolean checked(Object obj,String password) {
        if (null == obj) {
            throw new ValidationException("查询不到指定用户");
        }
        if (obj instanceof SysAdmin) {
            SysAdmin admin = (SysAdmin) obj;
            if (!admin.getPassword().equals(Md5Util.encrypt(password))) {
                throw new ValidationException("管理员名或密码错误");
            } else if (!Numerical.FIRST.equals(admin.getStatus())) {
                throw new ValidationException("管理员已被冻结");
            }
        }
        if (obj instanceof EmployeeParam) {
            EmployeeParam employee = (EmployeeParam) obj;
            String originalPwd = employee.getPwd();
            if (null == originalPwd || "".equals(originalPwd)) {
                throw new ValidationException("用户不存在");
            }
            return existUsernameAndPassword(originalPwd, password, employee.getEncrypt(),
                    employee.getStatus());
        }
        if (obj instanceof CustomerParam) {
            CustomerParam param = (CustomerParam) obj;
            return existUsernameAndPassword(param.getPwd(), password, param.getEncrypt(),  param.getStatus());
        }
        if (obj instanceof SupplierParam) {
            SupplierParam param = (SupplierParam) obj;
            return existUsernameAndPassword(param.getPwd(), password, param.getEncrypt(), param.getStatus());
        }
        return true;
    }

    /**
     * <h4>判断登录名与密码</h4>
     * @param ePwd 原始密码[数据查找]
     * @param pwd 页面接收密码
     * @param encrypt 加密字符
     * @param status 判断状态 状态不为1 为错误
     * @return
     */
    private boolean existUsernameAndPassword(String ePwd,String pwd, String encrypt,Integer status) {
        if (null == ePwd){
            throw new ValidationException("用户名或密码错误");
        }
        if (!ePwd.equals(Md5Util.encrypt(pwd, encrypt))) {
            throw new ValidationException("用户名或密码错误");
        }else if (!Numerical.FIRST.equals(status)) {
            throw new ValidationException("用户已被冻结，请联系管理员");
        }
        return true;
    }
}
