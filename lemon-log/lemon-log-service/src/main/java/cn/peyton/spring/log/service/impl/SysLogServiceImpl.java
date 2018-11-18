package cn.peyton.spring.log.service.impl;

import cn.peyton.spring.log.dao.SysLogMapper;
import cn.peyton.spring.log.dto.SearchLogDto;
import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.log.param.SearchLogParam;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.log.service.AbstractLogFactory;
import cn.peyton.spring.log.service.SysLogService;
import cn.peyton.spring.validator.Validation;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <h3>日志 Service 实现类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 10:58
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService{
    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public PageResult<SysLogWithBLOBs> searchPageList(SearchLogParam param, PageQuery page) {
        Validation.check(param);
        SearchLogDto dto = new SearchLogDto();
        dto.setType(param.getType());
        if (StringUtils.isNotBlank(param.getBeforeSeq())) {
            dto.setBeforeSeq(param.getBeforeSeq());
        }
        if (StringUtils.isNotBlank(param.getAfterSeq())) {
            dto.setAfterSeq(param.getAfterSeq());
        }
        if (StringUtils.isNotBlank(param.getOperator())) {
            dto.setOperator(param.getOperator());
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (StringUtils.isNotBlank(param.getFromTime())) {
                dto.setFromTime(dateFormat.parse(param.getFromTime()));
            }
            if (StringUtils.isNotBlank(param.getToTime())) {
                dto.setToTime(dateFormat.parse(param.getToTime()));
            }
        } catch (Exception e) {
            throw new ParamException("传入日期格式有问题,正确格式为: <yyyy-MM-dd HH:mm:ss>");
        }
        int count = sysLogMapper.countBySearch(dto);
        if (count > 0) {
            List<SysLogWithBLOBs> sysLogWithBLOBsList = sysLogMapper.getPageListBySerach(dto, page);
            return new PageResult<SysLogWithBLOBs>(sysLogWithBLOBsList,count);
        }
        return new PageResult<SysLogWithBLOBs>();
    }

    @Override
    public void recover(Long id, AbstractLogFactory abstractLogFactory) {
        SysLogWithBLOBs sysLog = sysLogMapper.selectByPrimaryKey(id);
        Preconditions.checkNotNull(sysLog, "待还原记录不存在");
        if (AbstractLogFactory.Holder.RECOVERY_YES == sysLog.getStatus()) {
            Preconditions.checkNotNull(sysLog, "该记录已经复原过,不能在次复原");
        }
        //调用
        abstractLogFactory.recover(sysLog);
    }

    @Override
    public <T> void save(T before,T after,AbstractLogFactory abstractLogFactory) {
        SysLogWithBLOBs sysLog = new SysLogWithBLOBs();
        //调用保存日志方法
        abstractLogFactory.save(sysLog,before,after,true);
    }
}
