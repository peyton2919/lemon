package cn.peyton.spring.basis.dao;

import cn.peyton.spring.basis.entity.Region;
import cn.peyton.spring.inf.IMapperAll;
import cn.peyton.spring.inf.IMapperLike;
import cn.peyton.spring.inf.IMapperBySelect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>地区 Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
public interface RegionMapper extends IMapperAll<Region>,
        IMapperLike<Region>,IMapperBySelect<Region>{
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Region record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Region record);

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
	int updateByPrimaryKey(Region record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Region record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Region selectByPrimaryKey(Long id);


	// ==================================== new create method ==================================== //

    /**
     * <h4>获取 全部 地区对象集合 [树]</h4>
     * @return 对象集合
     */
    List<Region> selectByTree();

    /**
     * <h>根据 父级编号 查找 地区对象集合</h>
     * @param parentId 父级编号
     * @return 对象集合
     */
    List<Region> selectByParentId(@Param("parentId") Long parentId);

    /**
     * <h4>根据level 查找 子地区集合</h4>
     * @param level 层级
     * @return 对象集合
     */
    List<Region> getChildRegionListByLevel(@Param("level") String level);

    /**
     * <h4>批量更新Level</h4>
     * @param regionList 对象集合
     */
    void batchUpdateLevel(@Param("regionList") List<Region> regionList);

    /**
     * <h4>判断</h4>
     * @param parentId 父级地区ID
     * @param name 名称
     * @param id 地区ID
     * @return 条数
     */
    int countByNameAndParentId(@Param("parentId") Long parentId, @Param("name") String name, @Param("id") Long id);

    /**
     * <h4>根据 地区ID 查找 条数</h4>
     * @param regiId 地区ID
     * @return 条数
     */
    int countByParentId(@Param("regiId") Long regiId);
}
