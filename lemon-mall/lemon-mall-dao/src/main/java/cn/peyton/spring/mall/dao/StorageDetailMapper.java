package cn.peyton.spring.mall.dao;

import cn.peyton.spring.mall.entity.StorageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>出入库明细 Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/14 09:24:23
 * @version 1.0.0
 * </pre>
*/
public interface StorageDetailMapper {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(StorageDetail record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(StorageDetail record);

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
	int updateByPrimaryKey(StorageDetail record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(StorageDetail record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	StorageDetail selectByPrimaryKey(Long id);


	// ==================================== new create method ==================================== //

    /**
     * <h4>批量插入</h4>
     * @param storageDetailList 出入库明细对象集合
     * @return 受影响行数
     */
    int batchInsert(@Param("storageDetailList") List<StorageDetail> storageDetailList);

    /**
     * <h4>根据出入库编号 删除 对象</h4>
     * @param storId 出入库编号
     * @return 受影响行数
     */
    int deleteByStorId(@Param("storId") Long storId);

    /**
     * <h4>根据出入库编号 查找 集合</h4>
     * @param storId 出入库编号
     * @return 出入库明细对象集合
     */
    List<StorageDetail> selectByStorId(@Param("storId") Long storId);


}
