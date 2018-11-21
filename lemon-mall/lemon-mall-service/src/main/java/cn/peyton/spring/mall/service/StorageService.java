package cn.peyton.spring.mall.service;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.inf.IServiceByLike;
import cn.peyton.spring.mall.entity.StorageDetail;
import cn.peyton.spring.mall.param.StorageParam;

import java.util.Date;
import java.util.List;

/**
 * <h3>出入库 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/14 09:24:23
 * @version 1.0.0
 * </pre>
*/
public interface StorageService extends IServiceByLike<StorageParam>{

    /**
     * <h4>添加</h4>
     * @param param 出入库对象
     */
    void save(StorageParam param);

    /**
     * <h4>更新</h4>
     * @param param 出入库对象
     */
    void update(StorageParam param);

    /**
     * <h4>更新状态</h4>
     * @param id 出入库编号
     */
    void delete(Long id);

    /**
     * <h4>根据出入库 查找 出入库对象</h4>
     * @param id 出入库编号
     * @return 出入库对象
     */
    StorageParam findById(Long id);

    /**
     * <h4>根据出入库编号 获取 出入库明细集合</h4>
     * @param id 出入库编号
     * @return 出入库明细集合
     */
    List<StorageDetail> findDetailById(Long id);

    /**
     * <h4>分页查找</h4>
     * @param page 分页对象
     * @return 出入库对象集合
     */
    PageResult<StorageParam> findByAll(PageQuery page);

    /**
     * <h4>根据员工编号 查找 集合</h4>
     * @param empId 员工编号
     * @param page 分页对象
     * @return 出入库对象集合
     */
    PageResult<StorageParam> findByEmpId(Long empId, PageQuery page);

    /**
     * <h4>根据仓库编号 查找 集合</h4>
     * @param warId 仓库编号
     * @param page 分页对象
     * @return 出入库对象集合
     */
    PageResult<StorageParam> findByWarId(Integer warId, PageQuery page);

    /**
     * <h4>根据时间 查找 集合</h4>
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @param page 分页对象
     * @return 出入库对象集合
     */
    PageResult<StorageParam> findByTime(Date beginTime, Date endTime, PageQuery page);

    /**
     * <h4>根据时间 查找 集合</h4>
     * @param direction 出入 库方向 [0 入库, 1 出库 ]
     * @param page 分页对象
     * @return 出入库对象集合
     */
    PageResult<StorageParam> findByDirection(Integer direction, PageQuery page);

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
    PageResult<StorageParam> findMultiCondition(PageQuery page, Integer warId, Integer direction, String comName,
                                                Date beginTime, Date endTime);
}
