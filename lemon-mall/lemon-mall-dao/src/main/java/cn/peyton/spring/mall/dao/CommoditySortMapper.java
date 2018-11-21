package cn.peyton.spring.mall.dao;

import cn.peyton.spring.inf.IMapperByAll;
import cn.peyton.spring.inf.IMapperByLike;
import cn.peyton.spring.inf.IMapperByRename;
import cn.peyton.spring.inf.IMapperBySelect;
import cn.peyton.spring.mall.entity.CommoditySort;

/**
 * <h3> Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 16:06:05
 * @version 1.0.0
 * </pre>
*/
public interface CommoditySortMapper extends IMapperByAll<CommoditySort>,
        IMapperByLike<CommoditySort>,IMapperBySelect<CommoditySort>,IMapperByRename<Integer> {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(CommoditySort record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(CommoditySort record);

	/**
	 * <h4>根据 主键 删除 对象</h4>
	 * @param id 主键
	 * @return 受影响的行数
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * <h4>更新 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKey(CommoditySort record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(CommoditySort record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	CommoditySort selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //


}
