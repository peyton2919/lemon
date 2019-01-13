package cn.peyton.spring.basis.service.impl;

import cn.peyton.spring.basis.bo.ColorConvertBo;
import cn.peyton.spring.basis.dao.ColorMapper;
import cn.peyton.spring.basis.entity.Color;
import cn.peyton.spring.basis.param.ColorParam;
import cn.peyton.spring.basis.service.ColorService;
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
 * <h3>颜色 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 09:16:50
 * @version 1.0.0
 * </pre>
*/
@Service("colorService")
public class ColorServiceImpl implements ColorService {
	@Resource
	private ColorMapper colorMapper;

    @Override
    public void save(ColorParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(colorMapper, param.getId(), param.getName())) {
            throw new GlobalException("已有相应颜色名称!");
        }
        Color info = param.convert();
        colorMapper.insertSelective(info);
    }

    @Override
    public void update(ColorParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(colorMapper, param.getId(), param.getName())) {
            throw new GlobalException("已有相应颜色名称!");
        }
        Color before = colorMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before,"侍更新的颜色不存在!");
        Color after = param.convert();
        colorMapper.updateByPrimaryKey(after);
    }

    @Override
    public void delete(Integer id) {
        colorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ColorParam findById(Integer id) {
        return new ColorParam().compat(colorMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<ColorParam> findByAll(PageQuery page) {
        int count = colorMapper.count();
        if (count > 0) {
            return new PageResult<ColorParam>(new ColorConvertBo().adapter(colorMapper.selectByAll(page)), count);
        }
        return new PageResult<ColorParam>();
    }

    @Override
    public PageResult<ColorParam> findLikeByKeyword(String keyword, PageQuery page) {
        int count = colorMapper.countLikeByKeyword(keyword);
        if (count > 0) {
            return new PageResult<ColorParam>(new ColorConvertBo().adapter(colorMapper.selectLikeByKeyword(keyword, page)), count);
        }
        return new PageResult<ColorParam>();
    }

    @Override
    public List<ColorParam> findBySelect() {
        return new ColorConvertBo().adapter(colorMapper.selectBySelect());
    }

}
