package cn.peyton.spring.mall.bo;

import cn.peyton.spring.def.BaseConvertBo;
import cn.peyton.spring.mall.entity.Commodity;
import cn.peyton.spring.mall.param.CommodityParam;

/**
 * <h3>商品 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.CommodityConvertBo.java
 * @createDate: 2018/10/4 11:25
 * @version: 1.0.0
 * </pre>
 */
public class CommodityConvertBo extends BaseConvertBo<CommodityParam,Commodity> {
    @Override
    public CommodityParam compat(Commodity info) {
        return new CommodityParam().compat(info);
    }
}
