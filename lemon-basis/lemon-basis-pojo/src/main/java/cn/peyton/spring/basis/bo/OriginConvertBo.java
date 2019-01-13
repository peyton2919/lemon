package cn.peyton.spring.basis.bo;

import cn.peyton.spring.basis.entity.Origin;
import cn.peyton.spring.basis.param.OriginParam;
import cn.peyton.spring.def.BaseConvertBo;

/**
 * <h3>产地 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.OriginConvertBo.java
 * @createDate: 2018/9/13 12:20
 * @version: 1.0.0
 * </pre>
 */
public final class OriginConvertBo extends BaseConvertBo<OriginParam, Origin> {


    @Override
    public OriginParam compat(Origin origin) {
        return new OriginParam().compat(origin);
    }
}
