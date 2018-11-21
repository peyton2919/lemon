package cn.peyton.spring.basis.service.impl;

import cn.peyton.spring.basis.bo.OriginBo;
import cn.peyton.spring.basis.dao.OriginMapper;
import cn.peyton.spring.basis.entity.Origin;
import cn.peyton.spring.basis.param.OriginParam;
import cn.peyton.spring.basis.service.OriginService;
import cn.peyton.spring.def.DefaultExistRename;
import cn.peyton.spring.exception.GlobalException;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>产地 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 09:16:50
 * @version 1.0.0
 * </pre>
*/
@Service("originService")
public class OriginServiceImpl implements OriginService {
	@Resource
	private OriginMapper originMapper;

    @Override
    public void save(OriginParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(originMapper, param.getId(), param.getName())) {
            throw new GlobalException("已有相同的产地名称!");
        }
        Origin info = param.convert();
        originMapper.insertSelective(info);

    }

    @Override
    public void update(OriginParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(originMapper, param.getId(), param.getName())) {
            throw new GlobalException("已有相同的产地名称!");
        }
        Origin before = originMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before, "待更新的产地不存在!");
        Origin after = param.convert();

        originMapper.updateByPrimaryKey(after);
    }

    @Override
    public void delete(Integer id) {
        originMapper.deleteByPrimaryKey(id);
    }

    @Override
    public OriginParam findById(Integer id) {
        return new OriginParam().compat(originMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<OriginParam> findByAll(PageQuery page) {
        PageResult<OriginParam> result = new PageResult<>();
        int count = originMapper.count();
        if (count > 0) {
            result.setData(new OriginBo().adapter(originMapper.selectByAll(page)));
            result.setTotal(count);
        }
        return result;
    }

    @Override
    public PageResult<OriginParam> findLikeByKeyword(String keyword, PageQuery page) {
        PageResult<OriginParam> result = new PageResult<>();
        int count = originMapper.countLikeByKeyword(keyword);
        if (count > 0) {
            result.setData(new OriginBo().adapter(originMapper.selectLikeByKeyword(keyword,page)));
            result.setTotal(count);
        }
        return result;
    }

    @Override
    public List<OriginParam> findBySelect() {
        return new OriginBo().adapter(originMapper.selectBySelect());
    }
}
