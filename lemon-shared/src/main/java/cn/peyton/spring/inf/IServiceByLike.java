package cn.peyton.spring.inf;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;

/**
 * <h3>模糊 查找 全部 Service 接口 .</h3>
 * <pre>
 *     <b style= "color:red;">T 为对象[用在页面的param]</b>
 *     <b>1. 根据名称模糊 分页 查找对象集合</b>
 *          List<T> findLikeByKeyword(String keyword,PageQuery page);
 * </pre>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.inf.IServiceByLike.java
 * @createDate: 2018/9/13 11:51
 * @version: 1.0.0
 * </pre>
 */
public interface IServiceByLike<T> {

    /**
     * <h4>分页模糊查找</h4>
     * @param keyword 关键字
     * @param page 分页对象
     * @return 对象集合
     */
    PageResult<T> findLikeByKeyword(String keyword, PageQuery page);
}
