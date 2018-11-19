package cn.peyton.spring.permission.dao;

import cn.peyton.spring.permission.entity.SysAcl;
import cn.peyton.spring.beans.PageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>权限 Mapper 接口</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 20:46
 * @version: 1.0.0
 * </pre>
 */
public interface SysAclMapper {

    /**
     * <h4>根据 权限ID 删除 权限对象</h4>
     * @param id 权限ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * <h4>插入 权限对象</h4>
     * @param record 权限对象
     * @return 受影响的行数
     */
    int insert(SysAcl record);

    /**
     * <h4>插入 权限对象[根据属性是否有值 插入]</h4>
     * @param record 权限对象
     * @return 受影响的行数
     */
    int insertSelective(SysAcl record);

    /**
     * <h4>根据 权限ID 查找 权限对象</h4>
     * @param id 权限ID
     * @return 权限对象
     */
    SysAcl selectByPrimaryKey(Integer id);

    /**
     * <h4>更新 权限对象[根据属性是否有值 更新]</h4>
     * @param record 权限对象
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(SysAcl record);

    /**
     * <h4>更新 权限对象</h4>
     * @param record 权限对象
     * @return 受影响的行数
     */
    int updateByPrimaryKey(SysAcl record);

    //================================ Private Custom==================================//

    /**
     * <h4>判断名称和权限模块ID</h4>
     * @param aclModuleId 权限模块ID
     * @param name 权限模块名称
     * @param id 权限点ID
     * @return
     */
    int countByNameAndAclModuleId(@Param("aclModuleId") Integer aclModuleId,
                                  @Param("name") String name, @Param("id") Integer id);

    /**
     * <h4>根据权限模块ID 计算 总行数</h4>
     * @param aclModuleId 权限模块ID
     * @return
     */
    int countByAclModuleId(@Param("aclModuleId") Integer aclModuleId);

    /**
     * <h4>根据权限模块ID 分页</h4>
     * @param aclModuleId 权限模块ID
     * @param page 分页对象
     * @return
     */
    List<SysAcl> selectPageByAclModuleId(@Param("aclModuleId") Integer aclModuleId, @Param("page") PageQuery page);

    /**
     * <h4></h4>
     * @return
     */
    List<SysAcl> selectByAll();

    /**
     * <h4>根据用户ID集合 查找 权限点集合</h4>
     * @param idList
     * @return
     */
    List<SysAcl> selectByIdList(@Param("idList") List<Integer> idList);

    /**
     * <h4>根据 url 获取 权限对象集合</h4>
     * @param url url链接
     * @return 权限对象集合
     */
    List<SysAcl> selectByUrl(@Param("url") String url);
}