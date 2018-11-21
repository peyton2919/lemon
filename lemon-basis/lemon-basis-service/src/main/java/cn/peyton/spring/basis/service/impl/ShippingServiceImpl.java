package cn.peyton.spring.basis.service.impl;

import cn.peyton.spring.basis.bo.ShippingBo;
import cn.peyton.spring.basis.dao.ShippingMapper;
import cn.peyton.spring.basis.entity.Shipping;
import cn.peyton.spring.basis.param.ShippingParam;
import cn.peyton.spring.basis.service.ShippingService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;

/**
 * <h3>运输  Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/11 14:22:56
 * @version 1.0.0
 * </pre>
*/
@Service("shippingInfoService")
public class ShippingServiceImpl implements ShippingService {
	@Resource
	private ShippingMapper shippingMapper;

    @Override
    public PageResult<ShippingParam> findLikeByKeywordAndPage(String keyword, PageQuery page) {
        int count = shippingMapper.countLikeByKeyword(keyword);
        if (count > 0) {
            return new PageResult<ShippingParam>(new ShippingBo().adapter(shippingMapper.selectLikeByKeyword(keyword,page)),count);
        }
        return new PageResult<ShippingParam>();
    }

    @Override
    public void save(ShippingParam param) {
        Validation.check(param);
        Shipping info = param.convert();
        info.setShipCreated(new Date());
        info.setShipUpdated(new Date());
        shippingMapper.insertSelective(info);

    }

    @Override
    public void update(ShippingParam param) {
        Validation.check(param);
        Shipping before = shippingMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before,"待更新的运输不存在");
        Shipping after = param.convert();
        after.setShipUpdated(new Date());
        shippingMapper.updateByPrimaryKey(after);

    }

    @Override
    public void delete(Long id) {
        shippingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ShippingParam findById(Long id) {
        return new ShippingParam().compat(shippingMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<ShippingParam> findByAll(PageQuery page) {
        int count = shippingMapper.count();
        if (count > 0) {
            return new PageResult<ShippingParam>(new ShippingBo().adapter(shippingMapper.selectByAll(page)), count);
        }
        return new PageResult<ShippingParam>();
    }

}
