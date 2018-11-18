package cn.peyton.spring.permission.common;

import cn.peyton.spring.def.BaseUser;

import java.util.List;

/**
 * <h3></h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.permission.common.AbstractEmployee.java
 * @createDate: 2018-11-19 0:13
 * @version: 1.0.0
 * </pre>
 */
public abstract class AbstractEmployee {

    public abstract List<BaseUser> findByIdList(List<Integer> ids);

    public List<BaseUser> find(List<Integer> ids) {
        return findByIdList(ids);
    }
}
