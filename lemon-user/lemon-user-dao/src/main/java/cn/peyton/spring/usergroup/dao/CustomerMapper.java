package cn.peyton.spring.usergroup.dao;

import cn.peyton.spring.inf.IMapperByAll;
import cn.peyton.spring.inf.IMapperByLike;
import cn.peyton.spring.inf.IMapperByRename;
import cn.peyton.spring.inf.IMapperBySelect;
import cn.peyton.spring.usergroup.entity.Customer;
import org.apache.ibatis.annotations.Param;

/**
 * <h3>客户 Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
public interface CustomerMapper extends IMapperByAll<Customer>,
        IMapperByLike<Customer>,IMapperByRename<Long>,IMapperBySelect<Customer> {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Customer record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Customer record);

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
	int updateByPrimaryKey(Customer record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Customer record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Customer selectByPrimaryKey(Long id);

	// ==================================== new create method ==================================== //

    /**
     * <h4>供应商登录</h4>
     * @param loginName 登录 名
     * @return 客户对象
     */
    Customer login(@Param("loginName") String loginName);

    /**
     * <h4>更新登录 次数</h4>
     * @param id
     * @return
     */
    int updateLoc(@Param("id") Long id);

    /**
     * <h4>更新登录 次数</h4>
     * @param id
     * @return
     */
    int updateHot(@Param("id") Long id);

    /**
     * <h4>判断密码</h4>
     * @param id 编号
     * @return
     */
    Customer existPwd(@Param("id") Long id);

    /**
     * <h4>更新密码</h4>
     * @param id 编号
     * @param pwd 密码
     * @return 受影响行数
     */
    int updatePwd(@Param("id") Long id, @Param("pwd") String pwd);
    /**
     * <h4>更新状态</h4>
     * @param id 编号
     * @param status 状态
     * @return 受影响行数
     */
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);

    /**
     * <h4>更新头像</h4>
     * @param id 编号
     * @param avatar 头像地址
     * @return 受影响行数
     */
    int updateAvatar(@Param("id") Long id, @Param("avatar") String avatar);

}
