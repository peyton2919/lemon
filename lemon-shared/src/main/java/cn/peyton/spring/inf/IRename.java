package cn.peyton.spring.inf;

/**
 * <h3>用来验证名称是否重名的接口</h3>
 * <pre>
 *      需要验证重名的Controller类,继承这个接口
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:30
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface IRename {
    /**
     * <h4>判断重名</h4>
     * @return 重名为true;
     */
    boolean isRename();
}
