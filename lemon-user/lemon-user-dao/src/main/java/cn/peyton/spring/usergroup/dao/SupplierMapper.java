package cn.peyton.spring.usergroup.dao;

import cn.peyton.spring.inf.IMapperByAll;
import cn.peyton.spring.inf.IMapperByLike;
import cn.peyton.spring.inf.IMapperByRename;
import cn.peyton.spring.inf.IMapperBySelect;
import cn.peyton.spring.usergroup.entity.Supplier;
import org.apache.ibatis.annotations.Param;

/**
 * <h3>供应商 Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/17 10:58:54
 * @version 1.0.0
 * </pre>
*/
public interface SupplierMapper extends IMapperByAll<Supplier>,
        IMapperByLike<Supplier>,IMapperByRename<Long>,IMapperBySelect<Supplier> {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Supplier record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Supplier record);

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
	int updateByPrimaryKey(Supplier record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Supplier record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Supplier selectByPrimaryKey(Long id);

	// ==================================== new create method ==================================== //

    /**
     * <h4>供应商登录</h4>
     * @param loginName 登录 名
     * @return 供应商对象
     */
    Supplier login(@Param("loginName") String loginName);

    /**
     * <h4>更新登录 次数</h4>
     * @param id
     * @return
     */
    int updateLoc(@Param("id") Long id);

    /**
     * <h4>判断密码</h4>
     * @param id 编号
     * @return
     */
    Supplier existPwd(@Param("id") Long id);

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
     * <h4>更新外网</h4>
     * @param id 编号
     * @param webSite 外接网址
     * @param webCode 连接外网标识码
     * @return 受影响行数
     */
    int updateWeb(@Param("id") Long id, @Param("webSite") String webSite, @Param("webCode") String webCode);

    /**
     * <h4>查找外网</h4>
     *
     * @param id 编号
     * @return 供应商对象
     */
    Supplier selectByWeb(@Param("id") Long id);

    /**
     * <h4>更新头像</h4>
     * @param id 编号
     * @param avatar 头像地址
     * @return 受影响行数
     */
    int updateAvatar(@Param("id") Long id, @Param("avatar") String avatar);

    /**
     * <h4>判断直接登录</h4>
     * @param loginName 登录名称
     * @param encryptPwd 密码
     * @return 供应商对象
     */
    Supplier directLogin(@Param("loginName") String loginName, @Param("encryptPwd") String encryptPwd);

}
