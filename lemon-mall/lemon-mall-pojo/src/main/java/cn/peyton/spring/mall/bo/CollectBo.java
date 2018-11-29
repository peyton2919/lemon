package cn.peyton.spring.mall.bo;

import cn.peyton.spring.def.BaseBo;
import cn.peyton.spring.mall.entity.Collect;
import cn.peyton.spring.mall.param.CollectParam;

/**
 * <h3>收藏[商品] 业务对象类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.mall.bo.CollectBo.java
 * @create date: 2018-11-29 16:41
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class CollectBo extends BaseBo<CollectParam,Collect> {
    @Override
    public CollectParam compat(Collect info) {
        return new CollectParam().compat(info);
    }
}
