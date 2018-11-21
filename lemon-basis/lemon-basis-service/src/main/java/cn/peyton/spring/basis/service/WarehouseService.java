package cn.peyton.spring.basis.service;

import cn.peyton.spring.basis.entity.Warehouse;
import cn.peyton.spring.basis.param.WarehouseParam;
import cn.peyton.spring.inf.IService;
import cn.peyton.spring.inf.IServiceBySelect;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;

/**
 * <h3>仓库 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/10 16:14:27
 * @version 1.0.0
 * </pre>
*/
public interface WarehouseService extends IService<Integer,WarehouseParam,Warehouse>,IServiceBySelect<WarehouseParam>{

    /**
     * <h4>分页模糊查找</h4>
     * @param keyword 关键字
     * @param page 分页对象
     * @return  分页返回对象集合
     */
    PageResult<WarehouseParam> findLikeByKeywordAndPage(String keyword, PageQuery page);
}
