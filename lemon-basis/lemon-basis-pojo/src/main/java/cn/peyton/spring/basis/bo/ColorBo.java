package cn.peyton.spring.basis.bo;

import cn.peyton.spring.basis.entity.Color;
import cn.peyton.spring.basis.param.ColorParam;
import cn.peyton.spring.def.BaseBo;

/**
 * <h3>颜色 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.ColorBo.java
 * @createDate: 2018/9/13 12:12
 * @version: 1.0.0
 * </pre>
 */
public final class ColorBo extends BaseBo<ColorParam,Color> {

    @Override
    public ColorParam compat(Color color) {
        return new ColorParam().compat(color);
    }
}
