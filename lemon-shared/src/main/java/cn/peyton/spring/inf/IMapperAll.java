package cn.peyton.spring.inf;

import cn.peyton.spring.beans.PageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>查找 全部接口</h3>
 * <pre>
 *     <b style= "color:red;">T 为对象[与数据库表对应]</b>
 *     <b>1. 分页 查找对象集合[全部]</b>
 *      List<T> selectByAll(@Param("page")PageQuery page);
 *     <b>2. 总行数{用在分页上},与selectByAll方法配合一起使用;</b>
 *     int count();
 * </pre>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.inf.IMapperAll.java
 * @createDate: 2018/9/13 10:18
 * @version: 1.0.0
 * </pre>
 */
public interface IMapperAll<T> {

    /**
     * <h4>分页查找全部</h4>
     * @param page 分页对象
     * @return 对象集合
     */
    List<T> selectByAll(@Param("page") PageQuery page);

    /**
     * <h4>查找全部数量</h4>
     * @return 总条数
     */
    int count();
}
