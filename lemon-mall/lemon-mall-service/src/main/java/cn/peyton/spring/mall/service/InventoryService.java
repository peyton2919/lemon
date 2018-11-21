package cn.peyton.spring.mall.service;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.mall.entity.Inventory;
import cn.peyton.spring.mall.param.InventoryParam;

import java.util.List;

/**
 * <h3>库存主 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/14 09:24:23
 * @version 1.0.0
 * </pre>
*/
public interface InventoryService {

    /**
     * <h4>添加</h4>
     * @param param 库存主对象
     */
    void save(InventoryParam param);

    /**
     * <h4>更新</h4>
     * @param param 库存主对象
     */
    void update(InventoryParam param);

    /**
     * <h4>更新明细与总数</h4>
     * @param param 库存主对象
     */
    void updateDetailAndTotal(InventoryParam param);

    /**
     * <h4>根据库存主编号 查找 库存主对象</h4>
     * @param id 库存主编号
     * @return 库存主对象
     */
    InventoryParam findById(Long id);

    /**
     * <h4>分页查找</h4>
     * @param page 分页对象
     * @return 库存主对象集合
     */
    PageResult<InventoryParam> findByAll(PageQuery page);

    /**
     * <h4>根据商品编号与仓库编号 查找 对象</h4>
     * @param comId 商品编号
     * @param warId 仓库编号
     * @return 库存主对象
     */
    InventoryParam findByComIdAndWarId(String comId, Integer warId);

    /**
     * <h4>根据商品编号 查找 集合</h4>
     * @param comId 商品编号
     * @param page 分页对象
     * @return 库存主对象集合
     */
    PageResult<InventoryParam> findByComId(String comId, PageQuery page);

    /**
     * <h4>根据商品编号 查找 集合</h4>
     * @param comId 商品编号
     * @return 库存主对象集合
     */
    List<Inventory> findDisplayByComId(String comId);

    /**
     * <h4>根据仓库编号 查找 集合</h4>
     * @param warId 仓库编号
     * @param page 分页对象
     * @return 库存主对象集合
     */
    PageResult<InventoryParam> findByWarId(Integer warId, PageQuery page);

    /**
     * <h4>根据商品名称 模糊查找 集合</h4>
     * @param comName 商品名称
     * @param page 分页对象
     * @return 库存主对象集合
     */
    PageResult<InventoryParam> findLikeByComName(String comName, PageQuery page);

}
