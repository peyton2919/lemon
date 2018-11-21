package cn.peyton.spring.basis.service.impl;

import cn.peyton.spring.basis.bo.PaymentModeBo;
import cn.peyton.spring.basis.dao.PaymentModeMapper;
import cn.peyton.spring.basis.entity.PaymentMode;
import cn.peyton.spring.basis.param.PaymentModeParam;
import cn.peyton.spring.basis.service.PaymentModeService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.def.DefaultExistRename;
import cn.peyton.spring.exception.ValidationException;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>付款方式 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
@Service("paymentModeService")
public class PaymentModeServiceImpl implements PaymentModeService {
	@Resource
	private PaymentModeMapper paymentModeMapper;

    @Override
    public void save(PaymentModeParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(paymentModeMapper, param.getId(), param.getName())) {
            throw new ValidationException("已有相同付款方式名称");
        }
        PaymentMode paymentMode = param.convert();
        paymentModeMapper.insertSelective(paymentMode);
    }

    @Override
    public void update(PaymentModeParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(paymentModeMapper, param.getId(), param.getName())) {
            throw new ValidationException("已有相同付款方式名称");
        }
        PaymentMode before = paymentModeMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before,"待更新的付款方式不存在");
        PaymentMode after = param.convert();
        paymentModeMapper.updateByPrimaryKey(after);
    }

    @Override
    public void delete(Integer id) {
        //todo 要先判断是否有引用 ,没有引用的状态下才能删除
    }

    @Override
    public PaymentModeParam findById(Integer id) {
        return new PaymentModeParam().compat(paymentModeMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<PaymentModeParam> findByAll(PageQuery page) {
        PageResult<PaymentModeParam> result = new PageResult<>();
        int count = paymentModeMapper.count();
        if (count > 0) {
            result.setTotal(count);
            result.setData(new PaymentModeBo().adapter(paymentModeMapper.selectByAll(page)));
        }
        return result;
    }

    @Override
    public PageResult<PaymentModeParam> findLikeByKeyword(String keyword, PageQuery page) {
        PageResult<PaymentModeParam> result = new PageResult<>();
        int count = paymentModeMapper.countLikeByKeyword(keyword);
        if (count > 0) {
            result.setTotal(count);
            result.setData(new PaymentModeBo().adapter(paymentModeMapper.selectLikeByKeyword(keyword,page)));
        }
        return result;
    }

    @Override
    public List<PaymentModeParam> findBySelect() {
        return new PaymentModeBo().adapter(paymentModeMapper.selectBySelect());
    }
}
