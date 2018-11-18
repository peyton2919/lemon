package cn.peyton.spring.permission.service;

import cn.peyton.spring.permission.param.CategoryParam;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;

import java.util.List;

/**
 * <h3>栏目 Service 接口 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/18 14:43
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface SysCategoryService {

    /**
     * <h4>添加对象</h4>
     * @param t 对象
     */
    void save(CategoryParam t);

    /**
     * <h4>更新对象</h4>
     * @param t 对象
     */
    void update(CategoryParam t);
    /**
     * <h4>根据主键删除对象</h4>
     * @param k 主键
     */
    void delete(Integer k);
    /**
     * <h4>根据主键查找对象</h4>
     * @param k 主键
     * @return 对象
     */
    CategoryParam findById(Integer k);

    /**
     * <h4>查找对象集合</h4>
     * @param pageQuery 分页对象
     * @return 对象集合
     */
    PageResult<CategoryParam> findByAllAndPage(PageQuery pageQuery);
    /**
     * <h4>更新状态</h4>
     * @param id 编号
     * @param status 状态0 不可用 1 可用 2 删除
     * @return
     */
    int updateStatus(Integer id, Integer status);

    /**
     * <h4>根据栏目类型查找</h4>
     * @param type 栏目类型
     * @return
     */
    PageResult<CategoryParam> findByType(Integer type);

    /**
     * <h4>根据栏目类型查找</h4>
     * @param type 栏目类型
     * @return
     */
    List<CategoryParam> findByCategory(Integer type);

    /**
     * <h4>根据栏目类型查找</h4>
     * @param type 栏目类型
     * @param page 分页对象
     * @return
     */
    PageResult<CategoryParam> findByTypeAndPage(Integer type, PageQuery page);

    /**
     * <h4>根据栏目父编号 查找</h4>
     * <pre>
     *     只查找3个字段[id,name,parentId]
     * </pre>
     * @param parentId 父编号 为-1时查找全部
     * @param isSelect 为true 查找下拉框[只查找状态可用]，否则 [查找状态可用和不可用]
     * @return
     */
    List<CategoryParam> findByParentId(Integer parentId, boolean isSelect);

    /**
     * <h4>根据名称模糊查找</h4>
     * @param name 名称
     * @param type 类型
     * @param page 分页对象
     * @return
     */
    PageResult<CategoryParam> findSearchByLikeName(String name, Integer type, PageQuery page);

}
