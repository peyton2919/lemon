package cn.peyton.spring.interceptor.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h3>防表单重复提交</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.interceptor.anno.Token.java
 * @createDate: 2018/9/20 9:43
 * @version: 1.0.0
 * </pre>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {
    /** 设置 Token */
    boolean save() default false;

    /** 移除 Token */
    boolean remove() default false;
}
