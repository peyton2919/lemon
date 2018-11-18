package cn.peyton.spring.permission.dao;

import cn.peyton.spring.permission.entity.SysAclModule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>权限模块 Mapper 接口</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 20:53
 * @version: 1.0.0
 * </pre>
 */
public interface SysAclModuleMapper {
    /**
     * <h4>根据 权限模块ID 删除权 限模块对象</h4>
     * @param id 权限模块ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * <h4>插入 权限模块对象</h4>
     * @param record 权限模块对象
     * @return 受影响的行数
     */
    int insert(SysAclModule record);

    /**
     * <h4>插入 权限模块对象[根据属性是否有值 插入]</h4>
     * @param record 权限模块对象
     * @return 受影响的行数
     */
    int insertSelective(SysAclModule record);

    /**
     * <h4>根据 权限模块ID 查找 权限模块对象</h4>
     * @param id 权限模块ID
     * @return 权限模块对象
     */
    SysAclModule selectByPrimaryKey(Integer id);

    /**
     * <h4>更新 权限模块对象[根据属性是否有值 更新]</h4>
     * @param record 权限模块对象
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(SysAclModule record);

    /**
     * <h4>更新 权限模块对象/h4>
     * @param record 权限模块对象
     * @return 受影响的行数
     */
    int updateByPrimaryKey(SysAclModule record);

    //================================ Private Custom==================================//

    /**
     * <h4>根据level 查找 子权限模块集合</h4>
     * @param level 层级
     * @return 权限模块对象集合
     */
    List<SysAclModule> getChildAclModuleListByLevel(@Param("level") String level);

    /**
     * <h4>批量更新Level</h4>
     * @param sysAclModuleList  权限模块对象集合
     */
    void batchUpdateLevel(@Param("sysAclModuleList") List<SysAclModule> sysAclModuleList);

    /**
     * <h4>判断</h4>
     * @param parentId 父级ID
     * @param name 名称
     * @param id 权限模块ID
     * @return 条数
     */
    int countByNameAndParentId(@Param("parentId") Integer parentId, @Param("name") String name, @Param("id") Integer id);

    /**
     * <h4>获取所有权限模块集合</h4>
     * @return 权限模块对象集合
     */
    List<SysAclModule> getAllAclModule();

    /**
     * <h4>删除</h4>
     * @param aclModuleId 权限模块ID
     * @return 条数
     */
    int countByParentId(@Param("aclModuleId") Integer aclModuleId);
}