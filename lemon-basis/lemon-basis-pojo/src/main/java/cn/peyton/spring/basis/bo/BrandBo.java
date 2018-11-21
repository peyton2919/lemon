package cn.peyton.spring.basis.bo;

import cn.peyton.spring.basis.entity.Brand;
import cn.peyton.spring.basis.param.BrandParam;
import cn.peyton.spring.def.BaseBo;

/**
 * <h3>品牌 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.BrandBo.java
 * @createDate: 2018/9/13 16:20
 * @version: 1.0.0
 * </pre>
 */
public final class BrandBo extends BaseBo<BrandParam,Brand> {
    @Override
    public BrandParam compat(Brand info) {
        return new BrandParam().compat(info);
    }
}
