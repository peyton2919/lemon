package cn.peyton.spring.inf;

/**
 * <h3>传递类 接口 .</h3>
 * <pre>
 *     参数 P T 用法
 *     P 表示 入参时验证用的对象[用在页面的param]
 *     T表示 查找出来 的对象[与数据库表对应]
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:30
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface IParam<P,T> {

    /**
     * <h4>对象转成 T 对象<h4>
     * @return T 对象
     */
    T convert();

    /**
     * <h4>T 对象转成 P 对象<h4>
     * @param t 对象
     * @return P 对象
     */
    P compat(T t);
}
