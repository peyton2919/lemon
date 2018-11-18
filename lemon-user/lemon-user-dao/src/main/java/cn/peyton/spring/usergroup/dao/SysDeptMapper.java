package cn.peyton.spring.usergroup.dao;

import cn.peyton.spring.usergroup.entity.SysDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>部门 Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/17 09:15:49
 * @version 1.0.0
 * </pre>
*/
public interface SysDeptMapper {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(SysDept record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(SysDept record);

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
	int updateByPrimaryKey(SysDept record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(SysDept record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	SysDept selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //

    /**
     * <h4>获取所有部门对象</h4>
     * @return 部门对象集合
     */
    List<SysDept> selectByAll();

    /**
     * <h4>根据level 查找 子部门集合</h4>
     * @param level 层级
     * @return 部门对象集合
     */
    List<SysDept> selectChildDeptListByLevel(@Param("level") String level);

    /**
     * <h4>批量更新Level</h4>
     * @param sysDeptList 部门对象集合
     */
    void batchUpdateLevel(@Param("sysDeptList") List<SysDept> sysDeptList);

    /**
     * <h4>判断</h4>
     * @param parentId 父级部门ID
     * @param name 名称
     * @param id 部门ID
     * @return 条数
     */
    int countByNameAndParentId(@Param("parentId") Integer parentId, @Param("name") String name, @Param("id") Integer id);

    /**
     * <h4>根据 部门ID 查找 条数</h4>
     * @param deptId 部门ID
     * @return 条数
     */
    int countByParentId(@Param("deptId") Integer deptId);

}
