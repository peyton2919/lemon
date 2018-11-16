package cn.peyton.spring.inf;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;

/**
 * <h3> Service接口 扩展</h3>
 * <pre>
 *     参数K T V 用法
 *     K 表示 主键数据 类型
 *     T 表示 入参时验证用的对象[用在页面的param]
 *     V 表示 查找出来 的对象[与数据库表对应]
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:32
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface IServiceExpand<K,T,V> extends IService<K,T,V> {

    /**
     * <h4>根据名称模糊查找对象集合</h4>
     * @param likeName 名称
     * @param page 分页对象
     * @return 对象集合
     */
    PageResult<T> findByLikeName(String likeName, PageQuery page);

    /**
     * <h4>判断重名</h4>
     * @param name 名称
     * @return 重名为true
     */
    boolean isRename(String name);
}
