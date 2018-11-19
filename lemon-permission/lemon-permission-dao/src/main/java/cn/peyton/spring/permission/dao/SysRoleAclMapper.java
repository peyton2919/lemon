package cn.peyton.spring.permission.dao;

import cn.peyton.spring.permission.entity.SysRoleAcl;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <h3>角色权限 Mapper 接口</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 21:07
 * @version: 1.0.0
 * </pre>
 */
public interface SysRoleAclMapper {
    /**
     * <h>根据 角色权限ID 删除 角色权限对象</h>
     * @param id 角色权限ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * <h>插入 角色权限对象</h>
     * @param record 角色权限对象
     * @return 受影响的行数
     */
    int insert(SysRoleAcl record);

    /**
     * <h>插入 角色权限对象[根据属性是否有值 插入]</h>
     * @param record 角色权限对象
     * @return 受影响的行数
     */
    int insertSelective(SysRoleAcl record);

    /**
     * <h>根据 角色权限ID 查找 角色权限对象</h>
     * @param id 角色权限ID
     * @return 角色权限对象
     */
    SysRoleAcl selectByPrimaryKey(Integer id);

    /**
     * <h>更新 角色权限对象[根据属性是否有值 更新]</h>
     * @param record 角色权限对象
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(SysRoleAcl record);

    /**
     * <h>更新 角色权限对象</h>
     * @param record 角色权限对象
     * @return 受影响的行数
     */
    int updateByPrimaryKey(SysRoleAcl record);

    //================================ Private Custom==================================//

    /**
     * <h4>根据角色ID集合 查找 权限ID集合</h4>
     * @param roleIdList
     * @return
     */
    List<Integer> selectAclIdListByRoleIdList(@Param("roleIdList") List<Integer> roleIdList);

    /**
     * <h4>根据角色ID 删除 角色权限集</h4>
     * @param roleId
     */
    void deleteByRoleId(@Param("roleId") int roleId);

    /**
     * <h4>批量添加 角色权限集合</h4>
     * @param roleAclList
     */
    void batchInsert(@Param("roleAclList") List<SysRoleAcl> roleAclList);

    /**
     * <h4>根据 权限ID 获取 角色ID集合</h4>
     * @param aclId 权限ID
     * @return 角色ID集合
     */
    List<Integer> selectRoleIdListByAclId(@Param("aclId") Integer aclId);
}