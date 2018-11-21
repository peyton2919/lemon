package cn.peyton.spring.basis.service;

import cn.peyton.spring.basis.entity.Origin;
import cn.peyton.spring.basis.param.OriginParam;
import cn.peyton.spring.inf.IService;
import cn.peyton.spring.inf.IServiceByLike;
import cn.peyton.spring.inf.IServiceBySelect;

/**
 * <h3>产地 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 09:16:50
 * @version 1.0.0
 * </pre>
*/
public interface OriginService extends IService<Integer,OriginParam,Origin>,
        IServiceByLike<OriginParam>,IServiceBySelect<OriginParam>{

}
