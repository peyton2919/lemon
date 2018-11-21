package cn.peyton.spring.usergroup.service;

import cn.peyton.spring.inf.IService;
import cn.peyton.spring.inf.IServiceByLike;
import cn.peyton.spring.usergroup.entity.Customer;
import cn.peyton.spring.usergroup.param.CustomerParam;

/**
 * <h3>客户 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
public interface CustomerService extends IService<Long,CustomerParam,Customer>,
        IServiceByLike<CustomerParam> {

    /**
     * <h4>客户登录</h4>
     * @param loginName 登录 名
     * @return 客户对象
     */
    CustomerParam login(String loginName);

    /**
     * <h4>更新登录 次数</h4>
     * @param id
     * @return
     */
    int updateLoc(Long id);

    /**
     * <h4>判断密码</h4>
     * @param id 编号
     * @param pwd 密码
     * @return
     */
    CustomerParam existPwd(Long id, String pwd);

    /**
     * <h4>更新密码</h4>
     * @param id 编号
     * @param pwd 密码
     * @return 受影响行数
     */
    void updatePwd(Long id, String pwd);

    /**
     * <h4>更新头像</h4>
     * @param id 编号
     * @param avatar 头像地址
     * @return 受影响行数
     */
    void updateAvatar(Long id, String avatar);

    /**
     * <h4>更新状态</h4>
     * @param id 编号
     * @param status 状态
     */
    void updateStatus(Long id, Integer status);

    interface Holder{
        /** 批发客户  */
        int CUSTOMER_WHOLESALE = 0;
        /** 零售客户  */
        int CUSTOMER_RETAIL = 1;
    }

}
