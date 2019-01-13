package cn.peyton.spring.inf;

import cn.peyton.spring.beans.PageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>模糊 查找 全部 Mapper 接口 .</h3>
 * <pre>
 *     <b style= "color:red;">T 为对象</b>
 *     <b>1. 根据名称模糊 分页 查找对象集合</b>
 *     List<T> selectLikeByKeyword(@Param("keyword") String keyword ,@Param("page") PageQuery page);
 *     <b>2. 根据名称模糊 查找 总行数{用在分页上}，与selectByLikeName方法配合一起使用;</b>
 *     int countLikeByKeyword(@Param("keyword") String keyword);
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
public interface IMapperLike<T> {

    /**
     * <h4>分页模糊查找</h4>
     * @param keyword 关键字
     * @param page 分页对象
     * @return 对象集合
     */
    List<T> selectLikeByKeyword(@Param("keyword") String keyword, @Param("page") PageQuery page);

    /**
     * <h4>根据关键字查找总条数</h4>
     * @param keyword 关键字
     * @return 条数
     */
    int countLikeByKeyword(@Param("keyword") String keyword);
}
