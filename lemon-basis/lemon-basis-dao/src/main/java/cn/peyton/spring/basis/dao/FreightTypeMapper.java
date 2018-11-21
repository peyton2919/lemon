package cn.peyton.spring.basis.dao;

import cn.peyton.spring.basis.entity.FreightType;
import cn.peyton.spring.inf.IMapperByAll;
import cn.peyton.spring.inf.IMapperByLike;
import cn.peyton.spring.inf.IMapperByRename;

/**
 * <h3>货运类型 Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018/09/09 19:01:41
 * @version: 1.0.0
 * </pre>
*/
public interface FreightTypeMapper extends IMapperByAll<FreightType>,
        IMapperByLike<FreightType>,IMapperByRename<Integer>{
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(FreightType record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(FreightType record);

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
	int updateByPrimaryKey(FreightType record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(FreightType record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	FreightType selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //


}
