package cn.peyton.spring.basis.service;

import cn.peyton.spring.basis.entity.SysWebConfig;
import cn.peyton.spring.basis.param.WebConfigBaseParam;
import cn.peyton.spring.basis.param.WebConfigCloseParam;
import cn.peyton.spring.basis.param.WebConfigCopyrightParam;
import cn.peyton.spring.basis.param.WebConfigExtParam;

/**
 * <h3>网站基础配置  Service 接口 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/21 15:50
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface SysWebConfigService{
    /**
     * <h4>根据 主键 查找 对象</h4>
     * @param id 主键
     * @return 对象
     */
    SysWebConfig findByPrimaryKey(Integer id);

    /**
     * <h4>更新基础配置</h4>
     * @param param 对象 [基础]
     */
    void updateBase(WebConfigBaseParam param);

    /**
     * <h4>根据ID 查找 基础配置</h4>
     * @param id 编号
     * @return 对象 [基础]
     */
    WebConfigBaseParam findBaseById(Integer id);

    /**
     * <h4>根据ID 查找 扩展配置</h4>
     * @param id 编号
     * @return 对象 [扩展]
     */
    WebConfigExtParam findExtById(Integer id);

    /**
     * <h4>更新扩展配置</h4>
     * @param param 对象 [扩展]
     */
    void updateExt(WebConfigExtParam param);

    /**
     * <h4>根据ID 查找 版权配置</h4>
     * @param id 编号
     * @return 对象 [版权]
     */
    WebConfigCopyrightParam findCopyrightById(Integer id);

    /**
     * <h4>更新版权配置</h4>
     * @param param 对象 [版权]
     */
    void updateCopyright(WebConfigCopyrightParam param);

    /**
     * <h4>根据ID 查找 关闭配置</h4>
     * @param id 编号
     * @return 对象 [关闭]
     */
    WebConfigCloseParam findCloseById(Integer id);

    /**
     * <h4>更新关闭配置</h4>
     * @param param 对象 [关闭]
     */
    void updateClose(WebConfigCloseParam param);

}
