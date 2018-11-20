package cn.peyton.spring.lemon.filter;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.def.BaseUser;
import cn.peyton.spring.inf.IUser;
import cn.peyton.spring.constant.Constants;
import cn.peyton.spring.constant.UserType;
import cn.peyton.spring.usergroup.param.AdminParam;
import cn.peyton.spring.usergroup.param.EmployeeParam;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <h3>登录过滤器</h3>
 * <pre>
 *     必需在web.xml配置
 *       <filter>
 *          <filter-name>loginFilter</filter-name>
 *          <filter-class>cn.peyton.spring.permission.filter.LoginFilter</filter-class>
 *      </filter>
 *      <filter-mapping>
 *          <filter-name>loginFilter</filter-name>
 *          <url-pattern>/sys/*</url-pattern>
 *          <url-pattern>/admin/*</url-pattern>
 *       </filter-mapping>
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/20 10:54
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class LoginFilter implements Filter {

    /** 错误时返回路径 */
    private static final String FAIL_URL = "/signin.jsp";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=======================login filter ===========================");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        //登录类型
        BaseUser baseUser = (BaseUser) session.getAttribute(Constants.CURRENT_USER.name());
        Integer userType = (Integer) session.getServletContext().getAttribute(Constants.CURRENT_USER_TYPE.name());
        if (null == baseUser && !"".equals(userType)){
            PrintWriter out = resp.getWriter();
            StringBuffer sb = new StringBuffer("<script type=\"text/javascript\" charset=\"UTF-8\">");
            sb.append("top.location.href='");
            if (IUser.ADMIN_TYPE_NUM.equals(userType) ||
                    IUser.EMPLOYEE_TYPE_NUM.equals(userType)){
                sb.append("/sign-in-emp.page");
            } else if (IUser.SUPPLIER_TYPE_NUM.equals(userType)) {
                sb.append("/sign-in-sup.page");
            } else if (IUser.CUSTOMER_TYPE_NUM.equals(userType)) {
                sb.append("/sign-in-cus.page");
            } else {
                sb.append("/");
            }
            session.getServletContext().removeAttribute(Constants.CURRENT_USER_TYPE.name());

            sb.append("'");
            sb.append("</script>");
            out.print(sb.toString());
            out.close();
            return;
        }
        System.out.println(userType);
        String type = baseUser.getUserType();
        if (UserType.EMPLOYEE.getValue().equals(type)) {
            EmployeeParam employee = (EmployeeParam) req.getSession().getAttribute(Constants.CURRENT_USER.name());
            if (null == employee) {
                resp.sendRedirect(FAIL_URL);
                return;
            }
            RequestHolder.add(employee);
        }else if (UserType.ADMIN.getValue().equals(type)) {
            AdminParam admin = (AdminParam) req.getSession().getAttribute(Constants.CURRENT_USER.name());
            if (null == admin) {
                resp.sendRedirect(FAIL_URL);
                return;
            }
            RequestHolder.add(admin);
        } else if (UserType.CUSTOMER.getValue().equals(type)) {

        } else if (UserType.SUPPLIER.getValue().equals(type)) {

        }
        RequestHolder.add(req);
        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }

    @Override
    public void destroy() {

    }
}
