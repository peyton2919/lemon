package cn.peyton.spring.mall.service;

import cn.peyton.spring.mall.param.AttentionParam;

import java.util.List;

/**
 * <h3>关注[商品] Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/29 16:34:23
 * @version 1.0.0
 * </pre>
*/
public interface AttentionService {

    /**
     * <h4>保存对象</h4>
     * @param param 对象
     */
    void save(AttentionParam param);

    /**
     * <h4>根据编号 更新状态</h4>
     * @param id 编号
     * @param status 状态 0 不关注，1 关注
     */
    void delete(Long id, Integer status);

    /**
     * <h4>根据编号 查找 对象</h4>
     * @param id 编号
     * @return 对象
     */
    AttentionParam findById(Long id);

    /**
     * <h4>根据客户编号和状态 查找 对象集合</h4>
     * @param cusId 客户编号
     * @param status 状态 0 不关注，1 关注
     * @return 关注对象集合
     */
    List<AttentionParam> findByCusIdAndStatus(Long cusId, Integer status);
}
