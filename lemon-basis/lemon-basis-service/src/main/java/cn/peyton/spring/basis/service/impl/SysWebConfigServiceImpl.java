package cn.peyton.spring.basis.service.impl;

import cn.peyton.spring.basis.dao.SysWebConfigMapper;
import cn.peyton.spring.basis.entity.SysWebConfig;
import cn.peyton.spring.basis.param.WebConfigBaseParam;
import cn.peyton.spring.basis.param.WebConfigCloseParam;
import cn.peyton.spring.basis.param.WebConfigCopyrightParam;
import cn.peyton.spring.basis.param.WebConfigExtParam;
import cn.peyton.spring.basis.service.SysWebConfigService;
import cn.peyton.spring.exception.GlobalException;
import cn.peyton.spring.file.FolderOperation;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <h3>网站基础配置 Service 实现类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/21 15:51
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Service("sysWebConfigService")
public class SysWebConfigServiceImpl implements SysWebConfigService {
	@Resource
	private SysWebConfigMapper sysWebConfigMapper;

    @Override
    public SysWebConfig findByPrimaryKey(Integer id) {
        return sysWebConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public WebConfigBaseParam findBaseById(Integer id) {
        return new WebConfigBaseParam().compat(sysWebConfigMapper.selectBaseById(id));
    }

    @Override
    @Transactional(rollbackFor = GlobalException.class)
    public void updateBase(WebConfigBaseParam param) {
        Validation.check(param);
        SysWebConfig before = sysWebConfigMapper.selectBaseById(param.getId());
        if (null == before) {
            //删除图片
            FolderOperation.delFile(param.getCompletePath());
            throw new GlobalException("待更新的基础配置不存在!");
        }
        SysWebConfig after = param.convert();
        after.setWebUpdated(new Date());
        int result = sysWebConfigMapper.updateBase(after);
        if (result < 1) {
            //删除图片
            FolderOperation.delFile(param.getCompletePath());
        }
    }

    @Override
    public WebConfigExtParam findExtById(Integer id) {
        return new WebConfigExtParam().compat(sysWebConfigMapper.selectExtById(id));
    }

    @Override
    public void updateExt(WebConfigExtParam param) {
        Validation.check(param);
        SysWebConfig before = sysWebConfigMapper.selectExtById(param.getId());
        CheckedUtil.checkNoNull(before,"待更新的扩展配置不存在!");
        SysWebConfig after = param.convert();
        after.setWebUpdated(new Date());
        sysWebConfigMapper.updateExt(after);


    }

    @Override
    public WebConfigCopyrightParam findCopyrightById(Integer id) {
        return new WebConfigCopyrightParam().compat(sysWebConfigMapper.selectCopyrightById(id));
    }

    @Override
    public void updateCopyright(WebConfigCopyrightParam param) {
        Validation.check(param);
        SysWebConfig before = sysWebConfigMapper.selectCopyrightById(param.getId());
        if (null == before) {
            //删除图片
            FolderOperation.delFile(param.getCompletePath());
            throw new GlobalException("待更新的基础配置不存在!");
        }
        SysWebConfig after = param.convert();
        after.setWebUpdated(new Date());
        int result = sysWebConfigMapper.updateCopyright(after);
        if (result < 1) {
            //删除图片
            FolderOperation.delFile(param.getCompletePath());
        }
    }

    @Override
    public WebConfigCloseParam findCloseById(Integer id) {
        return new WebConfigCloseParam().compat(sysWebConfigMapper.selectCloseById(id));
    }

    @Override
    public void updateClose(WebConfigCloseParam param) {
        Validation.check(param);
        SysWebConfig before = sysWebConfigMapper.selectCloseById(param.getId());
        CheckedUtil.checkNoNull(before,"待更新的关闭配置不存在!");
        SysWebConfig after = param.convert();
        after.setWebUpdated(new Date());
        sysWebConfigMapper.updateClose(after);

    }

}
