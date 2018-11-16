package cn.peyton.spring.common;

import cn.peyton.spring.def.BaseUser;

import javax.servlet.http.HttpServletRequest;

/**
 * <h3>Request Holder支持</h3>
 * <pre>
 *     所有的request 信息放到 RequestHodler下
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:47
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class RequestHolder {

    /** 当前用户线程 */
    private static final ThreadLocal<BaseUser> userHolder = new ThreadLocal<BaseUser>();
    /** Request线程 */
    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();


    /**
     * <h4>添加用户</h4>
     * @param user 用户
     */
    public static void add(BaseUser user) {
        userHolder.set(user);
    }

    /**
     * <h4>添加Request</h4>
     * @param request
     */
    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }

    /**
     * <h4>获取 用户</h4>
     * @return
     */
    public static BaseUser getCurrentUser() {
        return userHolder.get();
    }

    /**
     * <h4>获取Request</h4>
     * @return
     */
    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }

    /**
     * <h4>移除</h4>
     */
    public static void remove(){
        userHolder.remove();
        requestHolder.remove();
    }

}
