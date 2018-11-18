package cn.peyton.spring.permission.common;

import cn.peyton.spring.def.BaseUser;

import java.util.List;

/**
 * <h3>用户抽象 工厂类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.permission.common.AbstractUserFactory.java
 * @createDate: 2018-11-19 0:03
 * @version: 1.0.0
 * </pre>
 */
public abstract class AbstractUserFactory {

    public abstract List<BaseUser> findUser(Integer type);

    public static List<BaseUser> find(Integer type) {
        if (type == 0) {
            return
        }
    }
}
