package cn.peyton.spring.basis.bo;

import cn.peyton.spring.basis.entity.PaymentMode;
import cn.peyton.spring.basis.param.PaymentModeParam;
import cn.peyton.spring.def.BaseBo;

/**
 * <h3>付款方式 业务对象类</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * Email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.mall.bo.PaymentModeBo.java
 * CreateDate: 2018/11/2 12:07
 * Version: 1.0.0
 * </pre>
 * @author peytonYu
 */
public class PaymentModeBo extends BaseBo<PaymentModeParam,PaymentMode> {
    @Override
    public PaymentModeParam compat(PaymentMode info) {
        return new PaymentModeParam().compat(info);
    }
}
