package cn.peyton.spring.usergroup.bo;

import cn.peyton.spring.def.BaseBo;
import cn.peyton.spring.usergroup.entity.SysPost;
import cn.peyton.spring.usergroup.param.PostParam;

/**
 * <h3>职务 业务对象类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.usergroup.bo.PostBo.java
 * @create date: 2018/11/18 10:43
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class PostBo extends BaseBo<PostParam, SysPost> {
    @Override
    public PostParam compat(SysPost info) {
        return new PostParam().compat(info);
    }
}
