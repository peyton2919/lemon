package cn.peyton.spring.permission.bo;

import cn.peyton.spring.def.BaseConvertBo;
import cn.peyton.spring.permission.entity.SysCategory;
import cn.peyton.spring.permission.param.CategoryParam;

/**
 * <h3>栏目 业务对象类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.permission.bo.CategoryConvertBo.java
 * @create date: 2018/11/18 14:34
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class CategoryConvertBo extends BaseConvertBo<CategoryParam,SysCategory> {
    @Override
    public CategoryParam compat(SysCategory info) {
        return new CategoryParam().compat(info);
    }
}
