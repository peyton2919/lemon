package cn.peyton.spring.basis.service;

import cn.peyton.spring.basis.entity.PaymentMode;
import cn.peyton.spring.basis.param.PaymentModeParam;
import cn.peyton.spring.inf.IService;
import cn.peyton.spring.inf.IServiceByLike;
import cn.peyton.spring.inf.IServiceBySelect;

/**
 * <h3>付款方式 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
public interface PaymentModeService extends IService<Integer,PaymentModeParam,PaymentMode>,
        IServiceBySelect<PaymentModeParam>,IServiceByLike<PaymentModeParam> {

}
