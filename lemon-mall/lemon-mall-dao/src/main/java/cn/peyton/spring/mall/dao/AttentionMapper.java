package cn.peyton.spring.mall.dao;

import cn.peyton.spring.mall.entity.Attention;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>关注[商品] Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/29 16:34:23
 * @version 1.0.0
 * </pre>
*/
public interface AttentionMapper {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Attention record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Attention record);

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
	int updateByPrimaryKey(Attention record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Attention record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Attention selectByPrimaryKey(Long id);


	// ==================================== new create method ==================================== //

    /**
     * <h4>根据客户编号和状态 查找对象集合[商品编号]</h4>
     * @param cusId 客户编号
     * @param status 状态 0不关注，1关注
     * @return 关注对象集合
     */
    List<Attention> selectByCusIdAndStatus(@Param("cusId") Long cusId,@Param("status") Integer status);

    /**
     * <h4>根据客户编号和商品编号 查找 对象</h4>
     * @param cusId 客户编号
     * @param comId 商品编号
     * @return 关注对象
     */
    Attention selectByCusIdAndComId(@Param("cusId") Long cusId, @Param("comId") String comId);

    /**
     * <h4>更新状态</h4>
     * @param id 关注编号
     * @param status 状态 0 不关注, 1 关注
     * @return 受影响行数
     */
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);

}
