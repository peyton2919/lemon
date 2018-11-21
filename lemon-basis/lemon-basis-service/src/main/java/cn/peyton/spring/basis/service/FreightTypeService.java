package cn.peyton.spring.basis.service;

import cn.peyton.spring.basis.entity.FreightType;
import cn.peyton.spring.basis.param.FreightTypeParam;
import cn.peyton.spring.inf.IService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;

/**
 * <h3>货运类型 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/09 19:01:41
 * @version 1.0.0
 * </pre>
 * @author peyton
 */
public interface FreightTypeService extends IService<Integer,FreightTypeParam,FreightType>{


    /**
     * <h4>分页模糊查找</h4>
     * @param keyword 关键字
     * @param page 分页对象
     * @return  分页返回对象集合
     */
    PageResult<FreightTypeParam> findLikeByKeywordAndPage(String keyword, PageQuery page);
}
