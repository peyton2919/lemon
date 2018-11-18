package cn.peyton.spring.permission.dao;

import cn.peyton.spring.inf.IMapperByAll;
import cn.peyton.spring.permission.entity.SysCategory;
import cn.peyton.spring.beans.PageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>栏目 Mapper 接口 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/18 14:40
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface SysCategoryMapper extends IMapperByAll<SysCategory>{
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(SysCategory record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(SysCategory record);

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
	int updateByPrimaryKey(SysCategory record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(SysCategory record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	SysCategory selectByPrimaryKey(Integer id);


    // ==================================== new create method ==================================== //

    /**
     * <h4>根据ID查找 子类 并更新子类 状态</h4>
     * @param id 编号
     * @param status 状态
     * @return
     */
    int updateChildStatus(@Param("id") Integer id, @Param("status") Integer status);

    /**
     * <h4>根据栏目类型查找</h4>
     * @param type 栏目类型
     * @return
     */
    List<SysCategory> selectByType(@Param("type") Integer type);

    /**
     * <h4>根据栏目父编号 查找</h4>
     * <pre>
     *     只查找3个字段[id,name,pId]
     * </pre>
     * @param parentId 父编号 为-1时查找全部
     * @param isSelect 为true 查找下拉框[只查找状态可用]，否则 [查找状态可用和不可用]
     * @return
     */
    List<SysCategory> selectByParentId(@Param("parentId") Integer parentId, @Param("isSelect") boolean isSelect);

    /**
     * <h4>根据栏目类型查找,分页</h4>
     * @param type
     * @param page
     * @return
     */
    List<SysCategory> selectByTypeAndAll(@Param("type") Integer type, @Param("page") PageQuery page);

    /**
     * <h4>根据名称模糊查找</h4>
     * @param name 名称
     * @param page 分页对象
     * @return
     */
    List<SysCategory> selectSearchByLikeName(@Param("name") String name, @Param("type") Integer type, @Param("page") PageQuery page);

    /**
     * <h4>根据名称模糊查找条数</h4>
     * @param name 名称
     * @param type 类型 [0 顾客 1 供应商 2 员工 3 管理员]
     * @return
     */
    int countSearchByLikeName(@Param("name") String name, @Param("type") Integer type);

    /**
     * <h4>更新状态</h4>
     * @param id 编号
     * @param status 状态0 不可用 1 可用 2 删除
     * @return
     */
    int updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    /**
     * <h4>删除时判断是否还有子类</h4>
     * @param id
     * @return
     */
    int countChild(@Param("id") Integer id);

    /**
     * <h4>判断重名</h4>
     * @param id 编号
     * @param parentId 父编号
     * @param type 栏目类型
     * @param name 名称
     * @return 大于0 为重名
     */
    int countByName(@Param("id") Integer id, @Param("parentId") Integer parentId,
                    @Param("type") Integer type, @Param("name") String name);

    /**
     * <h4>计算栏目类型</h4>
     * @param type
     * @return
     */
    int countByType(@Param("type") Integer type);


}
