package cn.peyton.spring.usergroup.service;

import cn.peyton.spring.inf.IService;
import cn.peyton.spring.inf.IServiceLike;
import cn.peyton.spring.inf.IServiceBySelect;
import cn.peyton.spring.usergroup.entity.CustomerGrade;
import cn.peyton.spring.usergroup.param.CustomerGradeParam;

/**
 * <h3>客户等级 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
public interface CustomerGradeService extends IService<Integer,CustomerGradeParam,CustomerGrade>,
        IServiceBySelect<CustomerGradeParam>,IServiceLike<CustomerGradeParam> {

}
