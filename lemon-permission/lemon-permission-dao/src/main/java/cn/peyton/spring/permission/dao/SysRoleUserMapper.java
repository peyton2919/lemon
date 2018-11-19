package cn.peyton.spring.permission.dao;

import cn.peyton.spring.permission.entity.SysRoleUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>角色用户 Mapper 接口</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/19 11:10
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface SysRoleUserMapper {
    /**
     * <h4>根据 角色用户ID 删除 角色用户对象</h4>
     * @param id 角色用户ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * <h4>插入 角色用户对象</h4>
     * @param record 角色用户对象
     * @return 受影响的行数
     */
    int insert(SysRoleUser record);

    /**
     * <h4>插入 角色用户对象[根据属性是否有值 插入]</h4>
     * @param record 角色用户对象
     * @return 受影响的行数
     */
    int insertSelective(SysRoleUser record);

    /**
     * <h4>根据 角色用户ID 查找 角色用户对象</h4>
     * @param id 角色用户ID
     * @return 角色用户对象
     */
    SysRoleUser selectByPrimaryKey(Integer id);

    /**
     * <h4>更新 角色用户对象[根据属性是否有值 更新]</h4>
     * @param record 角色用户对象
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(SysRoleUser record);

    /**
     * <h4>更新 角色用户对象</h4>
     * @param record 角色用户对象
     * @return 受影响的行数
     */
    int updateByPrimaryKey(SysRoleUser record);

    //================================ Private Custom==================================//

    /**
     * <h4>根据用户ID 查找 角色ID集合</h4>
     * @param userId 用户ID集合
     * @return 角色ID集合
     */
    List<Integer> selectRoleIdListByUserId(@Param("userId") Integer userId);

    /**
     * <h4>根据角色ID 查找 用户ID</h4>
     * @param roleId 角色ID
     * @return 用户ID集合
     */
    List<Integer> selectUserIdListByRoleId(@Param("roleId") Integer roleId);

    /**
     * <h4>根据 角色ID 删除</h4>
     * @param roleId 角色ID
     */
    void deleteByRoleId(@Param("roleId") Integer roleId);

    /**
     * <h4>批量添加 角色用户对象</h4>
     * @param sysRoleUserList 角色用户对象集合
     */
    void batchInsert(@Param("roleUserList") List<SysRoleUser> sysRoleUserList);

    /**
     * <h4>根据角色ID集合 查找 用户ID</h4>
     * @param roleIdList 角色ID集合
     * @return 用户ID集合
     */
    List<Integer> selectUserIdListByRoleIdList(@Param("roleIdList") List<Integer> roleIdList);
}