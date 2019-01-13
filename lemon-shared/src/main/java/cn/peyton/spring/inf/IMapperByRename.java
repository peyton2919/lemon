package cn.peyton.spring.inf;

import org.apache.ibatis.annotations.Param;

/**
 * <h3>判断重名 Mapper 接口 .</h3>
 * <pre>
 *     <b style= "color:red;">K 为主键</b>
 *     <b>1.判断重名</b>
 *     int countByName(@Param("id") K id, @Param("name") String name);
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
public interface IMapperByRename<K> {

    /**
     * <h4>判断是否重名</h4>
     * @param id 编号
     * @param name 名称
     * @return 大于0 表示 重名
     */
    int countByName(@Param("id") K id, @Param("name") String name);


}
