package cn.peyton.spring.filter;

/**
 * <h3></h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:17
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public abstract class AuthorityVerification {

    /**
     * <h4>要执行验证的主要方法</h4>
     */
    public abstract void execute();

    public void exist() {
        execute();
    }
}
