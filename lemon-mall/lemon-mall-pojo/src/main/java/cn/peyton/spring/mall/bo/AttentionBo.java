package cn.peyton.spring.mall.bo;

import cn.peyton.spring.def.BaseBo;
import cn.peyton.spring.mall.entity.Attention;
import cn.peyton.spring.mall.param.AttentionParam;

/**
 * <h3>关注[商品] 业务对象类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.mall.bo.AttentionBo.java
 * @create date: 2018-11-29 16:39
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class AttentionBo extends BaseBo<AttentionParam,Attention> {
    @Override
    public AttentionParam compat(Attention info) {
        return new AttentionParam().compat(info);
    }
}
