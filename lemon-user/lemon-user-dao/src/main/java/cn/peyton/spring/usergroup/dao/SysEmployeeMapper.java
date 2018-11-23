package cn.peyton.spring.usergroup.dao;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.inf.IMapperByRename;
import cn.peyton.spring.usergroup.entity.SysEmployee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>员工 Mapper 接口 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 15:06
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface SysEmployeeMapper extends IMapperByRename<Long> {

    /**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(SysEmployee record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(SysEmployee record);

	/**
	 * <h4>根据 主键 删除 对象</h4>
	 * @param id 主键
	 * @return 受影响的行数
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * <h4>更新 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKey(SysEmployee record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(SysEmployee record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	SysEmployee selectByPrimaryKey(Long id);

    // ==================================== new create method ==================================== //

    /**
     * <h4>登录名或邮箱 查找 对象</h4>
     * @param keyword 关键字[登录名、邮箱]
     * @return SysUser对象
     */
    SysEmployee selectByKeyword(@Param("keyword") String keyword);

    /**
     * <h4>查找全部</h4>
     * <pre>必需要查找条件 emp_status = 1 </pre>
     * @param page 分页对象
     * @return 员工集合
     */
    List<SysEmployee> selectByAllAndPage(@Param("page") PageQuery page);

    /**
     * <h4>根据部门编号查找</h4>
     * <pre>必需要查找条件 emp_status = 1 </pre>
     * @param deptId 部门编号
     * @param page 分页对象
     * @return 员工集合
     */
    List<SysEmployee> selectByDeptId(@Param("deptId") Integer deptId, @Param("page") PageQuery page);

    /**
     * <h4>根据职务编号查找</h4>
     * <pre>必需要查找条件 emp_status = 1 </pre>
     * @param postId 职务编号
     * @param page 分页对象
     * @return 员工集合
     */
    List<SysEmployee> selectByPostId(@Param("postId") Integer postId, @Param("page") PageQuery page);

    /**
     * <h4>根据关键字模糊查找</h4>
     * <pre>
     *     必需要查找条件 emp_status = 1;
     *     查找的字段 [name,loginName,tel,phone,email,add];
     * </pre>
     * @param keyword 关键字
     * @param page 分页对象
     * @return 员工集合
     */
    List<SysEmployee> selectByLikeKeywrod(@Param("keyword") String keyword, @Param("page") PageQuery page);

    /**
     * <h4>可用的总行数</h4>
     * <pre>必需要查找条件 emp_status = 1 </pre>
     * @return 总行数
     */
    int count();

    /**
     * <h4>根据部门编号查找行数</h4>
     * <pre>必需要查找条件 emp_status = 1 </pre>
     * @param deptId 部门编号
     * @return 行数
     */
    int countByDeptId(@Param("deptId") Integer deptId);

    /**
     * <h4>根据职务编号查找行数</h4>
     * <pre>必需要查找条件 emp_status = 1 </pre>
     * @param postId 职务编号
     * @return 行数
     */
    int countByPostId(@Param("postId") Integer postId);

    /**
     * <h4>根据关键字查找行数</h4>
     * <pre>必需要查找条件 emp_status = 1 </pre>
     * @param keyword 关键字
     * @return 行数
     */
    int countByLikeKeyword(@Param("keyword") String keyword);

    /**
     * <h4>更新状态[0 不可用,1可用,2删除]</h4>
     * @param id 编号
     * @param status 状态值
     * @return 受影响行数
     */
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);

    /**
     * <h4>根据编号集合 查找对象集合</h4>
     * @param idList 编号集合
     * @return
     */
    List<SysEmployee> selectByIdList(@Param("idList") List<Integer> idList);

    /**
     * <h4>查找全部</h4>
     * <pre>必需要查找条件 emp_status = 1 </pre>
     * @return 员工集合
     */
    List<SysEmployee> selectByAll();

    /**
     * <h4>判断直接登录</h4>
     * @param loginName 登录名称
     * @param encryptPwd 密码
     * @return 大于0 表示成功
     */
    int directLogin(@Param("loginName") String loginName, @Param("encryptPwd") String encryptPwd);
}
