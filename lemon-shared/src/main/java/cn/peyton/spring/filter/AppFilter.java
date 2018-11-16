package cn.peyton.spring.filter;

import cn.peyton.spring.bootstarp.App;
import cn.peyton.spring.common.RequestHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <h3></h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:16
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class AppFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化数据
        System.out.println(" ================= AppFilter init ================= ");
        App.getConfigurator().configure();
        //todo 加载WebConfig对象

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        //todo 加载WebConfig对象
        RequestHolder.add((HttpServletRequest) request);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
