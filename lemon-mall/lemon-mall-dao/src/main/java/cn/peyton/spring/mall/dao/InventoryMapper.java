package cn.peyton.spring.mall.dao;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.inf.IMapperAll;
import cn.peyton.spring.inf.IMapperLike;
import cn.peyton.spring.mall.entity.Inventory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>主库存 Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/13 16:25:29
 * @version 1.0.0
 * </pre>
*/
public interface InventoryMapper extends IMapperAll<Inventory>,
        IMapperLike<Inventory> {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Inventory record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Inventory record);

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
	int updateByPrimaryKey(Inventory record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Inventory record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Inventory selectByPrimaryKey(Long id);


	// ==================================== new create method ==================================== //

    /**
     * <h4>更新总数与明细</h4>
     * @param inventory 库存主对象
     * @return 受影响行数
     */
    int updateDetailAndTotal(Inventory inventory);

    /**
     * <h4>根据商品编号与仓库编号 查找 对象</h4>
     * @param comId 商品编号
     * @param warId 仓库编号
     * @return 库存主对象
     */
    Inventory selectByComIdAndWarId(@Param("comId") String comId, @Param("warId") Integer warId);

    /**
     * <h4>根据商品编号 查找 集合</h4>
     * @param comId 商品编号
     * @param page 分页对象
     * @return 库存主对象集合
     */
    List<Inventory> selectByComId(@Param("comId") String comId, @Param("page") PageQuery page);

    /**
     * <h4>根据商品编号 查找 集合</h4>
     * @param comId 商品编号
     * @return 库存主对象集合
     */
    List<Inventory> selectDisplayByComId(@Param("comId") String comId);

    /**
     * <h4>根据商品编号 查找 条数</h4>
     * @param comId 商品编号
     * @return  条数
     */
    int countByComId(@Param("comId") String comId);

    /**
     * <h4>根据仓库编号 查找 集合</h4>
     * @param warId 仓库编号
     * @param page 分页对象
     * @return 库存主对象集合
     */
    List<Inventory> selectByWarId(@Param("warId") Integer warId, @Param("page") PageQuery page);

    /**
     * <h4>根据仓库编号 查找 条数</h4>
     * @param warId 仓库编号
     * @return 条数
     */
    int countByWarId(@Param("warId") Integer warId);

}
