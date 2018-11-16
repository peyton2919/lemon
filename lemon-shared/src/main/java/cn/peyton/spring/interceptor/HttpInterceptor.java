package cn.peyton.spring.interceptor;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.log.LogUtil;
import cn.peyton.spring.util.JsonMapper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <h3>HTTP 拦截器</h3>
 * <pre>
 *     配置spring 管理
 *     <mvc:interceptors>
 *          <bean class="cn.peyton.spring.perm.common.HttpInterceptor"/>
 *      </mvc:interceptors>
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:40
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class HttpInterceptor extends HandlerInterceptorAdapter {


    /**
     * <h4>请求之前</h4>
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        Map parameterMap = request.getParameterMap();
        LogUtil.info("request start . url:{}, params:{}",url, JsonMapper.obj2String(parameterMap));
        return true;
    }

    /**
     * h4>正常结束之后</h4>
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = request.getRequestURL().toString();
        Map parameterMap = request.getParameterMap();
        LogUtil.info("request finished . url:{}, params:{}",url, JsonMapper.obj2String(parameterMap));
    }

    /**
     * h4>请求结束之后 {包括异常}</h4>
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURL().toString();
        Map parameterMap = request.getParameterMap();
        LogUtil.info("request exception . url:{}, params:{}",url, JsonMapper.obj2String(parameterMap));
        removeThreadLocalInfo();
    }

    /**
     * <h4>移除</h4>
     */
    public void removeThreadLocalInfo() {
        RequestHolder.remove();
    }
}
