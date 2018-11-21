package cn.peyton.spring.basis.bo;

import cn.peyton.spring.basis.entity.FreightType;
import cn.peyton.spring.basis.param.FreightTypeParam;
import cn.peyton.spring.def.BaseBo;

/**
 * <h3>货运类型 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.FreightTypeBo.java
 * @createDate: 2018/9/13 16:27
 * @version: 1.0.0
 * </pre>
 */
public final class FreightTypeBo extends BaseBo<FreightTypeParam, FreightType> {

    @Override
    public FreightTypeParam compat(FreightType info) {
        return new FreightTypeParam().compat(info);
    }
}
