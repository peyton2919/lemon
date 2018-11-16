package cn.peyton.spring.interceptor;

import cn.peyton.spring.interceptor.anno.Token;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * <h3></h3>
 * <pre>
 *     1. 在controller类 要跳转进入保存方法前上加入注解@Token(remove=true)
 *     2. 在controller类 要保存方法上加入注解@Token(save=true)
 *     3. 页面中加入隐藏域
 *     <input type="hidden" name="token" value="${token}">
 * </pre>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.interceptor.TokenInterceptor.java
 * @createDate: 2018/9/20 9:46
 * @version: 1.0.0
 * </pre>
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

    private final static String TOKEN = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token annoToken = method.getAnnotation(Token.class);
            if (null != annoToken) {
                boolean needSave = annoToken.save();
                if (needSave) {
                    request.getSession(false).setAttribute(TOKEN, UUID.randomUUID().toString());
                }
                boolean needRemove = annoToken.remove();
                if (needRemove) {
                    if (!existRemove(request)) {
                        return false;
                    }
                    request.getSession(false).removeAttribute(TOKEN);
                }
            }
            return true;
        }else {
            return super.preHandle(request, response, handler);
        }
    }

    private boolean existRemove(HttpServletRequest request) {
        String serverToken = (String) request.getSession(false).getAttribute(TOKEN);
        if (null == serverToken) {
            return true;
        }
        String clientToken = request.getParameter(TOKEN);
        if (null == clientToken) {
            return true;
        }
        if (!serverToken.equals(clientToken)) {
            return true;
        }
        return false;
    }
}
