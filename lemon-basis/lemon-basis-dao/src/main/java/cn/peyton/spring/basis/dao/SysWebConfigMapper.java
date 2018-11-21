package cn.peyton.spring.basis.dao;

import cn.peyton.spring.basis.entity.SysWebConfig;
import org.apache.ibatis.annotations.Param;

/**
 * <h3>网站基础配置 Mapper 接口 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/21 15:49
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface SysWebConfigMapper {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(SysWebConfig record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(SysWebConfig record);

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
	int updateByPrimaryKey(SysWebConfig record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(SysWebConfig record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
    SysWebConfig selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //

    /**
     * <h4>根据ID 查找 基础配置</h4>
     * @param id 编号
     * @return SysWebConfig 对象 [基础]
     */
    SysWebConfig selectBaseById(@Param("id") Integer id);

    /**
     * <h4>更新基础配置</h4>
     * @param webConfig SysWebConfig 对象 [基础]
     * @return 受影响的行数
     */
    int updateBase(SysWebConfig webConfig);

    /**
     * <h4>根据ID 查找 扩展配置</h4>
     * @param id 编号
     * @return SysWebConfig 对象 [扩展]
     */
    SysWebConfig selectExtById(@Param("id") Integer id);

    /**
     * <h4>更新扩展配置</h4>
     * @param webConfig SysWebConfig 对象 [扩展]
     * @return 受影响的行数
     */
    int updateExt(SysWebConfig webConfig);

    /**
     * <h4>根据ID 查找 版权配置</h4>
     * @param id 编号
     * @return  SysWebConfig 对象 [版权]
     */
    SysWebConfig selectCopyrightById(@Param("id") Integer id);

    /**
     * <h4>更新版权配置</h4>
     * @param webConfig SysWebConfig 对象 [版权]
     * @return 受影响的行数
     */
    int updateCopyright(SysWebConfig webConfig);

    /**
     * <h4>根据ID 查找 关闭配置</h4>
     * @param id 编号
     * @return  SysWebConfig 对象 [关闭]
     */
    SysWebConfig selectCloseById(@Param("id") Integer id);

    /**
     * <h4>更新关闭配置</h4>
     * @param webConfig SysWebConfig 对象 [关闭]
     * @return 受影响的行数
     */
    int updateClose(SysWebConfig webConfig);

}
