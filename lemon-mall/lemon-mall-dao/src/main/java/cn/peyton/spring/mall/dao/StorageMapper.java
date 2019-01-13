package cn.peyton.spring.mall.dao;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.inf.IMapperAll;
import cn.peyton.spring.inf.IMapperLike;
import cn.peyton.spring.mall.entity.Storage;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <h3>出入库 Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/14 09:24:23
 * @version 1.0.0
 * </pre>
*/
public interface StorageMapper extends IMapperAll<Storage>,
        IMapperLike<Storage> {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Storage record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Storage record);

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
	int updateByPrimaryKey(Storage record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Storage record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Storage selectByPrimaryKey(Long id);


	// ==================================== new create method ==================================== //

    /**
     * <h4>更新状态</h4>
     * @param id 编号
     * @param status 状态
     * @return
     */
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);

    /**
     * <h4>更新总数与时间</h4>
     * @param storage
     * @return
     */
    int updateTotal(Storage storage);

    /**
     * <h4>根据员工编号 查找 集合</h4>
     * @param empId 员工编号
     * @param page 分页对象
     * @return 出入库对象集合
     */
    List<Storage> selectByEmpId(@Param("empId") Long empId, @Param("page") PageQuery page);

    /**
     * <h4>根据员工编号 查找 条数</h4>
     * @param empId 员工编号
     * @return 条数
     */
    int countByEmpId(@Param("empId") Long empId);

    /**
     * <h4>根据仓库编号 查找 集合</h4>
     * @param warId  仓库编号
     * @param page 分页对象
     * @return 出入库对象集合
     */
    List<Storage> selectByWarId(@Param("warId") Integer warId, @Param("page") PageQuery page);

    /**
     * <h4>根据仓库编号 查找 条数</h4>
     * @param warId 仓库编号
     * @return 条数
     */
    int countByWarId(@Param("warId") Integer warId);

    /**
     * <h4>根据时间段 查找 集合</h4>
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @param page 分页对象
     * @return 出入库对象集合
     */
    List<Storage> selectByTime(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime,
                               @Param("page") PageQuery page);

    /**
     * <h4>根据时间段 查找 条数</h4>
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @return 条数
     */
    int countByTime(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    /**
     * <h4>根据方向 查找 集合</h4>
     * @param direction 方向
     * @param page 分页对象
     * @return  出入库对象集合
     */
    List<Storage> selectByDirection(@Param("direction") Integer direction, @Param("page") PageQuery page);

    /**
     * <h4>根据方向 查找 条数</h4>
     * @param direction 方向
     * @return 条数
     */
    int countByDirection(@Param("direction") Integer direction);

    /**
     * <h4>多条件查找 集合</h4>
     * @param page 分页对象
     * @param warId 仓库编号
     * @param direction 方向 0 入库 1出库
     * @param comName 商品名称
     * @param beginTime 开始时间
     * @param endTime 结束时
     * @return 出入库对象集合
     */
    List<Storage> selectMultiCondition(@Param("page") PageQuery page, @Param("warId") Integer warId,
                                       @Param("direction") Integer direction, @Param("comName") String comName,
                                       @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    /**
     * <h4>多条件查找 条数</h4>
     * @param warId 仓库编号
     * @param direction 方向 0 入库 1出库
     * @param comName 商品名称
     * @param beginTime 开始时间
     * @param endTime 结束时
     * @return 条数
     */
    int countMultiCondition(@Param("warId") Integer warId,
                            @Param("direction") Integer direction, @Param("comName") String comName,
                            @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

}
