package cn.peyton.spring.log.dao;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.inf.IMapper;
import cn.peyton.spring.log.dto.SearchLogDto;
import cn.peyton.spring.log.entity.SysLog;
import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.log.param.SearchLogParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3>日志 Mapper 接口</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 10:34
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface SysLogMapper{
    /**
     * <h4>根据 日志ID 查找 日志对象</h4>
     * @param id 日志ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * <h4>插入 日志对象</h4>
     * @param record 日志对象
     * @return 受影响的行数
     */
    int insert(SysLogWithBLOBs record);

    /**
     * <h4>插入 日志对象[根据属性是否有值 插入]</h4>
     * @param record 日志对象
     * @return 受影响的行数
     */
    int insertSelective(SysLogWithBLOBs record);

    /**
     * <h4>根据 日志ID 查找 日志对象</h4>
     * @param id 日志ID
     * @return 日志对象
     */
    SysLogWithBLOBs selectByPrimaryKey(Long id);

    /**
     * <h4>更新 日志对象[根据属性是否有值 更新]</h4>
     * @param record 日志对象
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(SysLogWithBLOBs record);

    /**
     * <h4></h4>
     * @param record 日志对象
     * @return 受影响的行数
     */
    int updateByPrimaryKeyWithBLOBs(SysLogWithBLOBs record);

    /**
     * <h4>更新 日志对象</h4>
     * @param record 日志对象
     * @return 受影响的行数
     */
    int updateByPrimaryKey(SysLog record);

    //================================ Private Custom==================================//

    /**
     * <h4>计算</h4>
     * @param dto SearchLogDto对象
     * @return 条数
     */
    int countBySearch(@Param("dto") SearchLogDto dto);

    /**
     * <h4>根据查询条件 分页查找 日志对象集合</h4>
     * @param dto SearchLogDto对象
     * @param page 分页对象
     * @return 日志对象集合
     */
    List<SysLogWithBLOBs> getPageListBySerach(@Param("dto") SearchLogDto dto, @Param("page") PageQuery page);
}