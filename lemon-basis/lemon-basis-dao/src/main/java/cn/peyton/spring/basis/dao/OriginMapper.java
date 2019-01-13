package cn.peyton.spring.basis.dao;

import cn.peyton.spring.basis.entity.Origin;
import cn.peyton.spring.inf.IMapperAll;
import cn.peyton.spring.inf.IMapperLike;
import cn.peyton.spring.inf.IMapperByRename;
import cn.peyton.spring.inf.IMapperBySelect;

/**
 * <h3>产地 Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 09:16:50
 * @version 1.0.0
 * </pre>
*/
public interface OriginMapper extends IMapperAll<Origin>,
        IMapperLike<Origin>,IMapperBySelect<Origin>,IMapperByRename<Integer> {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Origin record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Origin record);

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
	int updateByPrimaryKey(Origin record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Origin record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Origin selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //


}
