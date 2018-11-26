package cn.peyton.spring.usergroup.service;

import cn.peyton.spring.usergroup.param.AdminParam;

/**
 * <h3>管理员 Service 接口 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/18 16:10
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface SysAdminService {
    /**
     * <h4>根据登录名 查找 对象</h4>
     * @param keyword 关键字[登录名]
     * @return 对象
     */
    AdminParam findByKeyword(String keyword);

    /**
     * <h4>判断直接登录</h4>
     * @param loginName 登录名称
     * @param encryptPwd 密码
     * @return 管理员对象
     */
    AdminParam directLogin(String loginName, String encryptPwd);


}
