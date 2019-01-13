package cn.peyton.spring.mall.dao;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.inf.IMapperAll;
import cn.peyton.spring.inf.IMapperLike;
import cn.peyton.spring.inf.IMapperUpdateStatus;
import cn.peyton.spring.mall.entity.Commodity;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * <h3>商品 Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/23 21:44:35
 * @version 1.0.0
 * </pre>
*/
public interface CommodityMapper extends IMapperAll<Commodity>,
        IMapperLike<Commodity>,IMapperUpdateStatus<String>{
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Commodity record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Commodity record);

	/**
	 * <h4>根据 主键 删除 对象</h4>
	 * @param id 主键
	 * @return 受影响的行数
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * <h4>更新 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKey(Commodity record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Commodity record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Commodity selectByPrimaryKey(String id);


	// ==================================== new create method ==================================== //

    /**
     * <h4>更新热度{每点击一次+1}</h4>
     * @param id 商品编号
     * @return 受影响行数
     */
    int updateHot(@Param("id") String id);

    /**
     * <h4>更新图片{主图和图片}</h4>
     * @param id 商品编号
     * @param mainImg 主图片地址
     * @param images 图片集合
     * @return 受影响行数
     */
    int updateImages(@Param("id") String id, @Param("mainImg") String mainImg, @Param("images") String images);

    /**
     * <h4>根据商品编号 查找 主图片地址</h4>
     * @param id 商品编号
     * @return 主图片地址
     */
    String selectMainImgById(@Param("id") String id);

    /**
     * <h4>根据价格 查找 商品对象集合</h4>
     * @param page 分页对象
     * @param type 类型 这里指3种 {1:成本价; 2:零售价; 3:批发价}
     * @param min 最小单价
     * @param max 最大单价
     * @return 商品对象集合
     */
    List<Commodity> selectByPriceBetween(@Param("page") PageQuery page, @Param("type") Integer type, @Param("min") BigDecimal min, @Param("max") BigDecimal max);

    /**
     * <h4>根据价格 计算行数</h4>
     * @param type 类型 这里指3种 {1:成本价; 2:零售价; 3:批发价}
     * @param min 最小单价
     * @param max 最大单价
     * @return 行数
     */
    int countPriceBetween(@Param("type") Integer type, @Param("min") BigDecimal min, @Param("max") BigDecimal max);

    /**
     * <h4>根据 产地编号 查找 商品对象集合</h4>
     * @param page 分页对象
     * @param oriId 产地编号
     * @return 商品对象集合
     */
    List<Commodity> selectByOriId(@Param("page") PageQuery page, @Param("oriId") Integer oriId);

    /**
     * <h4>根据 产地编号 计算行数</h4>
     * @param oriId 产地编号
     * @return 行数
     */
    int countOriId(@Param("oriId") Integer oriId);

    /**
     * <h4>根据商品类目编号 查找 商品对象集合</h4>
     * @param page 分页对象
     * @param cocaId 商品类目编号
     * @return 商品对象集合
     */
    List<Commodity> selectByCocaId(@Param("page") PageQuery page, @Param("cocaId") Long cocaId);

    /**
     * <h4>根据商品类目编号 计算行数</h4>
     * @param cocaId 商品类目编号
     * @return 行数
     */
    int countCocaId(@Param("cocaId") Long cocaId);

}
