package cn.peyton.spring.lemon.filter;

import cn.peyton.spring.common.ApplicationContextHelper;
import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.def.BaseUser;
import cn.peyton.spring.log.LogUtil;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.constant.ResponseCode;
import cn.peyton.spring.permission.service.SysCoreService;
import cn.peyton.spring.util.JsonMapper;
import com.google.common.base.Splitter;
import com.google.common.collect.Sets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <h3>权限控制 拦截</h3>
 * <pre>
 *      必需在web.xml配置
 *     <filter>
 *          <filter-name>aclControlFilter</filter-name>
 *          <filter-class>cn.peyton.spring.permission.filter.AclControlFilter</filter-class>
 *      </filter>
 *      <filter-mapping>
 *          <filter-name>aclControlFilter</filter-name>
 *          <url-pattern>/sys/*</url-pattern>
 *          <url-pattern>/admin/*</url-pattern>
 *      </filter-mapping>
 * </pre>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @mailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018/7/6 14:12
 * @version: 1.0.0
 * </pre>
 */
/**
 * <h3>权限控制 拦截</h3>
 * <pre>
 *      必需在web.xml配置
 *     <filter>
 *          <filter-name>aclControlFilter</filter-name>
 *          <filter-class>cn.peyton.spring.permission.filter.AclControlFilter</filter-class>
 *      </filter>
 *      <filter-mapping>
 *          <filter-name>aclControlFilter</filter-name>
 *          <url-pattern>/sys/*</url-pattern>
 *          <url-pattern>/admin/*</url-pattern>
 *      </filter-mapping>
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/20 9:16
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class AclControlFilter implements Filter {

    /** 白名单的URL */
    private static Set<String> exclusionUrlSet = Sets.newConcurrentHashSet();
    /**  无权限URL 访问地址 */
    private final static String noAuthUrl = "/sys/user/noAuth.page";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取配置信息
        String exclusionUrls = filterConfig.getInitParameter("exclusionUrls");
        List<String> exclusionUrlList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(exclusionUrls);
        //过滤白名单的URL
        exclusionUrlSet = Sets.newConcurrentHashSet(exclusionUrlList);
        exclusionUrlSet.add(noAuthUrl);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        //过滤逻辑
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        //获取request中的所有参数
        Map requestMap = request.getParameterMap();
        //白名单处理逻辑
        if (exclusionUrlSet.contains(servletPath)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        BaseUser sysUser = RequestHolder.getCurrentUser();
        if (sysUser == null) {
            LogUtil.info("有人拜访: {},但是没有登录,参数: {}", servletPath, JsonMapper.obj2String(requestMap));
            noAuth(request, response);
            return;
        }

        SysCoreService sysCoreService = ApplicationContextHelper.popBean(SysCoreService.class);
        //调用权限比对
        if (!sysCoreService.hasUrlAcl(servletPath)) {
            //无权限 操作
            LogUtil.info("{} 访问: {},但是没有登录,参数: {}",
                    JsonMapper.obj2String(sysUser), servletPath, JsonMapper.obj2String(requestMap));
            noAuth(request, response);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }

    @Override
    public void destroy() {

    }

    // ========================================  Private Method ======================================== //

    /**
     * <h4>无权限</h4>
     *
     * @param request
     * @param response
     */
    private void noAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String servletPath = request.getServletPath();
        if (servletPath.endsWith(".json")) {
            JsonData jsonData = JsonData.fail(ResponseCode.NEED_LOGIN.getCode(),"没有访问权限,如需要访问,请联系管理员");
            response.setHeader("Content-Type", "application/json");
            response.getWriter().print(JsonMapper.obj2String(jsonData));
        } else {
            clientRedirect(noAuthUrl, response);
        }
        return;
    }

    private void clientRedirect(String url, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", "text/html");
        response.getWriter().print("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" + "<head>\n" + "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\"/>\n"
                + "<title>跳转中...</title>\n" + "</head>\n" + "<body>\n" + "跳转中，请稍候...\n" + "<script type=\"text/javascript\">//<![CDATA[\n"
                + "window.location.href='" + url + "?ret='+encodeURIComponent(window.location.href);\n" + "//]]></script>\n" + "</body>\n" + "</html>\n");
    }
}
