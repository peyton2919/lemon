package cn.peyton.spring.mall.dao;

import cn.peyton.spring.inf.IMapperByAll;
import cn.peyton.spring.inf.IMapperByLike;
import cn.peyton.spring.inf.IMapperBySelect;
import cn.peyton.spring.mall.entity.CommodityCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3> Mapper 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 22:13:17
 * @version 1.0.0
 * </pre>
*/
public interface CommodityCategoryMapper extends IMapperByAll<CommodityCategory>,IMapperByLike<CommodityCategory>,
        IMapperBySelect<CommodityCategory>{
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(CommodityCategory record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(CommodityCategory record);

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
	int updateByPrimaryKey(CommodityCategory record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(CommodityCategory record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	CommodityCategory selectByPrimaryKey(Long id);


	// ==================================== new create method ==================================== //

    /**
     * <h4>根据level 查找 子部门集合</h4>
     * @param level 层级
     * @return 部门对象集合
     */
    List<CommodityCategory> selectChildCommodityCategoryListByLevel(@Param("level") String level);

    /**
     * <h4>批量更新Level</h4>
     * @param CommodityCategories 对象集合
     */
    void batchUpdateLevel(@Param("CommodityCategories") List<CommodityCategory> CommodityCategories);

    /**
     * <h4>判断</h4>
     * @param parentId 父级ID
     * @param name 名称
     * @param id ID
     * @return 条数
     */
    int countByNameAndParentId(@Param("parentId") Long parentId, @Param("name") String name, @Param("id") Long id);

    /**
     * <h4>根据 ID 查找 条数</h4>
     * @param id ID
     * @return 条数
     */
    int countByParentId(@Param("id") Long id);

}
