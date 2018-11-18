package cn.peyton.spring.permission.dao;

import cn.peyton.spring.permission.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>角色 Mapper 接口</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 21:08
 * @version: 1.0.0
 * </pre>
 */
public interface SysRoleMapper {
    /**
     * <h4>根据角色ID 删除 角色对象</h4>
     * @param id 角色ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * <h4>插入 角色对象</h4>
     * @param record 角色对象
     * @return 受影响的行数
     */
    int insert(SysRole record);

    /**
     * <h4>插入角色对象[根据属性是否有值 插入]</h4>
     * @param record 角色对象
     * @return 受影响的行数
     */
    int insertSelective(SysRole record);

    /**
     * <h4>根据 角色ID 查找 角色对象</h4>
     * @param id 角色ID
     * @return 角色对象
     */
    SysRole selectByPrimaryKey(Integer id);

    /**
     * <h4>更新 角色对象[根据属性是否有值 更新]</h4>
     * @param record 角色对象
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * <h4>更新 角色对象</h4>
     * @param record 角色对象
     * @return 受影响的行数
     */
    int updateByPrimaryKey(SysRole record);

    //================================ Private Custom==================================//

    /**
     * <h4>查找所有的角色集合</h4>
     * @return
     */
    List<SysRole> getAll();

    /**
     * <h4>判断角色名称是否同名</h4>
     * @param name 角色名称
     * @param id 角色ID
     * @return 大于0表示存在
     */
    int countByName(@Param("name") String name, @Param("id") Integer id);

    /**
     * <h4>根据角色ID集合 获取 角色对象集合</h4>
     * @param idList
     * @return
     */
    List<SysRole> getByIdList(@Param("idList") List<Integer> idList);
}