package cn.peyton.spring.log.service;

import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.log.param.SearchLogParam;

/**
 * <h3>日志 Service 接口</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 10:51
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface SysLogService {

    /**
     * <h4>分页查找日志列表</h4>
     * @param param
     * @param page
     * @return
     */
    PageResult<SysLogWithBLOBs> searchPageList(SearchLogParam param, PageQuery page);
    /**
     * <h4>数据还原</h4>
     * @param id 日志ID
     * @param abstractLogFactory 抽象日志工厂
     */
    void recover(Long id,AbstractLogFactory abstractLogFactory);

    /**
     * <h4>保存 部门日志</h4>
     * @param before 之前对象
     * @param after 之后对象
     * @param abstractLogFactory 抽象日志工厂
     */
    <T> void save(T before,T after,AbstractLogFactory abstractLogFactory);

}
