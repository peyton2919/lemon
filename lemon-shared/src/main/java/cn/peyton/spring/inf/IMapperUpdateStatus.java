package cn.peyton.spring.inf;

import org.apache.ibatis.annotations.Param;

/**
 * <h3>更新状态 Mapper 接口 .</h3>
 * <pre>
 *     <b style= "color:red;">K 为主键</b>
 *     <b>1. 更新状态</b>
 *     int updateStatus(@Param("id") K id, @Param("status") Integer status);
 * </pre>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.inf.IMapperUpdateStatus.java
 * @createDate: 2018-09-21 23:41
 * @version: 1.0.0
 * </pre>
 */
public interface IMapperUpdateStatus<K> {

    /**
     * <h4>更新状态</h4>
     * @param id 主键
     * @param status 状态值
     * @return 受影响行数
     */
    int updateStatus(@Param("id") K id, @Param("status") Integer status);
}
