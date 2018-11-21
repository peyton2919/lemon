package cn.peyton.spring.basis.service;

import cn.peyton.spring.basis.entity.Color;
import cn.peyton.spring.basis.param.ColorParam;
import cn.peyton.spring.inf.IService;
import cn.peyton.spring.inf.IServiceByLike;
import cn.peyton.spring.inf.IServiceBySelect;

/**
 * <h3>颜色 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 09:16:50
 * @version 1.0.0
 * </pre>
*/
public interface ColorService extends IService<Integer,ColorParam,Color>,
        IServiceBySelect<ColorParam>,IServiceByLike<ColorParam>{

}
