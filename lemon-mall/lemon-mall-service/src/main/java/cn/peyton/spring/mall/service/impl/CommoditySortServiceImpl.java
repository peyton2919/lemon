package cn.peyton.spring.mall.service.impl;

import cn.peyton.spring.def.DefaultExistRename;
import cn.peyton.spring.exception.GlobalException;
import cn.peyton.spring.mall.bo.CommoditySortBo;
import cn.peyton.spring.mall.entity.CommoditySort;
import cn.peyton.spring.mall.param.CommoditySortParam;
import cn.peyton.spring.mall.service.CommoditySortService;
import cn.peyton.spring.mall.dao.CommoditySortMapper;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.beans.ResultAdapter;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>商品分类 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 16:06:05
 * @version 1.0.0
 * </pre>
*/
@Service("commoditySortService")
public class CommoditySortServiceImpl implements CommoditySortService {
	@Resource
	private CommoditySortMapper commoditySortMapper;

    @Override
    public void save(CommoditySortParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(commoditySortMapper, param.getId(), param.getName())) {
            throw new GlobalException("已有相同商品分类名称");
        }
        CommoditySort info = param.convert();
        commoditySortMapper.insertSelective(info);

    }

    @Override
    public void update(CommoditySortParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(commoditySortMapper, param.getId(), param.getName())) {
            throw new GlobalException("已有相同商品分类名称");
        }
        CommoditySort before = commoditySortMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before,"侍更新的商品分类不存在!");
        CommoditySort after = param.convert();

        commoditySortMapper.updateByPrimaryKey(after);
    }

    @Override
    public void delete(Integer id) {
        commoditySortMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CommoditySortParam findById(Integer id) {
        return new CommoditySortParam().compat(commoditySortMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<CommoditySortParam> findByAll(PageQuery page) {
        return ResultAdapter.adapt(commoditySortMapper, page, new CommoditySortBo());
    }

    @Override
    public PageResult<CommoditySortParam> findLikeByKeyword(String keyword, PageQuery page) {
        return ResultAdapter.adapt(commoditySortMapper, keyword, page, new CommoditySortBo());
    }

    @Override
    public List<CommoditySortParam> findBySelect() {
        return new CommoditySortBo().adapter(commoditySortMapper.selectBySelect());
    }
}
