package cn.peyton.spring.basis.bo;

import cn.peyton.spring.basis.entity.Region;
import cn.peyton.spring.basis.param.RegionParam;
import cn.peyton.spring.def.BaseConvertBo;

/**
 * <h3>地区 业务对象类</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * Email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.mall.bo.RegionConvertBo.java
 * CreateDate: 2018/10/30 11:34
 * Version: 1.0.0
 * </pre>
 * @author peytonyu
 */
public class RegionConvertBo extends BaseConvertBo<RegionParam,Region> {
    @Override
    public RegionParam compat(Region info) {
        return new RegionParam().compat(info);
    }
}
