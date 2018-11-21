package cn.peyton.spring.basis.dao;

import cn.peyton.spring.basis.entity.Shipping;
import cn.peyton.spring.beans.PageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>运输 Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/11 14:22:56
 * @version 1.0.0
 * </pre>
*/
public interface ShippingMapper {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Shipping record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Shipping record);

	/**
	 * <h4>根据 主键 删除 对象</h4>
	 * @param id 主键
	 * @return 受影响的行数
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * <h4>更新 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKey(Shipping record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Shipping record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Shipping selectByPrimaryKey(Long id);


	// ==================================== new create method ==================================== //

    /**
     * <h4>分页查找全部</h4>
     * @param page 分页对象
     * @return 对象集合
     */
    List<Shipping> selectByAll(@Param("page") PageQuery page);

    /**
     * <h4>分页模糊查找</h4>
     * @param keyword 关键字
     * @param page 分页对象
     * @return 对象集合
     */
    List<Shipping> selectLikeByKeyword(@Param("keyword") String keyword, @Param("page") PageQuery page);

    /**
     * <h4>查找全部数量</h4>
     * @return 总条数
     */
    int count();

    /**
     * <h4>根据关键字查找总条数</h4>
     * @param keyword 关键字
     * @return 条数
     */
    int countLikeByKeyword(@Param("keyword") String keyword);


}
