package cn.peyton.spring.basis.dao;

import cn.peyton.spring.basis.entity.Warehouse;
import cn.peyton.spring.inf.IMapperByAll;
import cn.peyton.spring.inf.IMapperByLike;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>仓库 Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/10 16:14:27
 * @version 1.0.0
 * </pre>
*/
public interface WarehouseMapper extends IMapperByAll<Warehouse>,IMapperByLike<Warehouse>{
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Warehouse record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Warehouse record);

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
	int updateByPrimaryKey(Warehouse record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Warehouse record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Warehouse selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //

    /**
     * <h4>判断是否重名</h4>
     * @param id 编号
     * @param name 名称
     * @return 大于0 表示 重名
     */
    int countByName(@Param("id") Integer id, @Param("name") String name);

    /**
     * <h4>下拉框 查找 </h4>
     * @return
     */
    List<Warehouse> selectBySelect();
}
