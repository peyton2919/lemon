package cn.peyton.spring.mall.dao;

import cn.peyton.spring.inf.IMapperAll;
import cn.peyton.spring.inf.IMapperLike;
import cn.peyton.spring.mall.entity.DeletePicture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>删除图片 Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/10 10:18:11
 * @version 1.0.0
 * </pre>
*/
public interface DeletePictureMapper extends IMapperAll<DeletePicture>,IMapperLike<DeletePicture> {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(DeletePicture record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(DeletePicture record);

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
	int updateByPrimaryKey(DeletePicture record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(DeletePicture record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	DeletePicture selectByPrimaryKey(Long id);


	// ==================================== new create method ==================================== //

    /**
     * <h4>插入多个删除图片</h4>
     * @param deletePictures
     * @return
     */
    int batchInsert(@Param("deletePictures") List<DeletePicture> deletePictures);


}
