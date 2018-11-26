package cn.peyton.spring.usergroup.service;

import cn.peyton.spring.inf.IService;
import cn.peyton.spring.inf.IServiceByLike;
import cn.peyton.spring.inf.IServiceByRename;
import cn.peyton.spring.inf.IServiceBySelect;
import cn.peyton.spring.usergroup.entity.Supplier;
import cn.peyton.spring.usergroup.param.SupplierParam;

/**
 * <h3>供应商 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/17 10:58:54
 * @version 1.0.0
 * </pre>
*/
public interface SupplierService extends IService<Long,SupplierParam,Supplier>,
        IServiceByLike<SupplierParam>,IServiceByRename<Long>,IServiceBySelect<SupplierParam>{

    /**
     * <h4>供应商登录</h4>
     * @param loginName 登录 名
     * @return 供应商对象
     */
    SupplierParam login(String loginName);

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
    SupplierParam existPwd(Long id, String pwd);

    /**
     * <h4>更新密码</h4>
     * @param id 编号
     * @param pwd 密码
     * @return 受影响行数
     */
    void updatePwd(Long id, String pwd);

    /**
     * <h4>更新外网</h4>
     * @param id 编号
     * @param webSite 外接网址
     * @param webCode 连接外网标识码
     * @return 受影响行数
     */
    void updateWeb(Long id, String webSite, String webCode);

    /**
     * <h4>查找外网</h4>
     *
     * @param id 编号
     * @return 供应商对象
     */
    SupplierParam findByWeb(Long id);

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

    /**
     * <h4>判断直接登录</h4>
     * @param loginName 登录名称
     * @param encryptPwd 密码
     * @return 供应商对象
     */
    SupplierParam directLogin(String loginName, String encryptPwd);
}
