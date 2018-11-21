package cn.peyton.spring.basis.service;

import cn.peyton.spring.basis.entity.Shipping;
import cn.peyton.spring.basis.param.ShippingParam;
import cn.peyton.spring.inf.IService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;

/**
 * <h3>运输 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/11 14:22:56
 * @version 1.0.0
 * </pre>
*/
public interface ShippingService extends IService<Long,ShippingParam,Shipping>{

    /**
     * <h4>分页模糊查找</h4>
     * @param keyword 关键字
     * @param page 分页对象
     * @return  分页返回对象集合
     */
    PageResult<ShippingParam> findLikeByKeywordAndPage(String keyword, PageQuery page);
}
