package cn.peyton.spring.inf;

import cn.peyton.spring.beans.PageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>Mapper扩展 接口 .</h3>
 * <pre>
 *     <b style= "color:red;">K 为主键,T 为对象[与数据库表对应]</b>
 *     <b>1. 分页 查找对象集合[全部]</b>
 *      List<T> selectByAll(@Param("page")PageQuery page);
 *     <b>2. 总行数{用在分页上},与selectByAll方法配合一起使用;</b>
 *     int count();
 *     <b>3. 根据名称模糊 分页 查找对象集合</b>
 *     List<T> selectByLikeName(@Param("likeName") String likeName ,@Param("page") PageQuery page);
 *     <b>4. 根据名称模糊 查找 总行数{用在分页上}，与selectByLikeName方法配合一起使用;</b>
 *     int countLikeName(@Param("likeName") String likeName);
 *     <b>5.判断重名</b>
 *     int isRename(String name);
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:28
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface IMapperExtension<K,T> {

    /**
     * <h4>查找对象集合</h4>
     * @param pageQuery 分页对象
     * @return 对象集合
     */
    List<T> selectByAll(@Param("pageQuery") PageQuery pageQuery);

    /**
     * <h4>根据名称模糊查找对象集合</h4>
     * @param likeName 名称
     * @param pageQuery 分页对象
     * @return 对象集合
     */
    List<T> selectByLikeName(@Param("likeName") String likeName, @Param("pageQuery") PageQuery pageQuery);

    /**
     * <h4>判断重名</h4>
     * @param name 名称
     * @return 返回行数
     */
    int isRename(String name);

    /**
     * <h4>总行数{用在分页上}</h4>
     * <pre>
     * 与selectByAll方法一起使用;
     * </pre>
     * @return 总行数
     */
    int count();

    /**
     * <h4>根据名称模糊查找总行数{用在分页上}</h4>
     * <pre>
     * 与selectByLikeName方法一起使用;
     * </pre>
     * @param likeName
     * @return
     */
    int countLikeName(@Param("likeName") String likeName);
}
