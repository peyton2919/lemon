package cn.peyton.spring.mall.service.impl;

import cn.peyton.spring.enums.Status;
import cn.peyton.spring.mall.bo.AttentionConvertBo;
import cn.peyton.spring.mall.entity.Attention;
import cn.peyton.spring.mall.param.AttentionParam;
import cn.peyton.spring.mall.service.AttentionService;
import cn.peyton.spring.mall.dao.AttentionMapper;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>关注[商品] Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/29 16:34:23
 * @version 1.0.0
 * </pre>
*/
@Service("attentionService")
public class AttentionServiceImpl implements AttentionService {
	@Resource
	private AttentionMapper attentionMapper;

    @Override
    public void save(AttentionParam param) {

        Validation.check(param);
        //todo 获取 客户编号 {从session中获取}
        Long customerId = 1L;
        Attention attention = attentionMapper.selectByCusIdAndComId(customerId, param.getComId());
        if (null == attention.getId()) {
            attention = param.convert();
            attention.setCusId(customerId);
            attentionMapper.insertSelective(attention);
        } else {
            attentionMapper.updateStatus(attention.getId(), Status.NORMAL.getCode());
        }
    }

    @Override
    public void delete(Long id, Integer status) {
        attentionMapper.updateStatus(id, status);
    }

    @Override
    public AttentionParam findById(Long id) {
        return new AttentionParam().compat(attentionMapper.selectByPrimaryKey(id));
    }

    @Override
    public List<AttentionParam> findByCusIdAndStatus(Long cusId, Integer status) {
        return new AttentionConvertBo().adapter(attentionMapper.selectByCusIdAndStatus(cusId,status));
    }
}
