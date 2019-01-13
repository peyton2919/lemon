package cn.peyton.spring.mall.service.impl;

import cn.peyton.spring.enums.Status;
import cn.peyton.spring.mall.bo.CollectConvertBo;
import cn.peyton.spring.mall.entity.Collect;
import cn.peyton.spring.mall.param.CollectParam;
import cn.peyton.spring.mall.service.CollectService;
import cn.peyton.spring.mall.dao.CollectMapper;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>收藏[商品] Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/29 16:34:23
 * @version 1.0.0
 * </pre>
*/
@Service("collectService")
public class CollectServiceImpl implements CollectService {
	@Resource
	private CollectMapper collectMapper;

    @Override
    public void save(CollectParam param) {

        Validation.check(param);
        //todo 获取 客户编号 {从session中获取}
        Long customerId = 1L;
        Collect collect = collectMapper.selectByCusIdAndComId(customerId, param.getComId());
        if (null == collect || null == collect.getId()) {
            collect = param.convert();
            collect.setCusId(customerId);
            collectMapper.insertSelective(collect);
        } else {
            collectMapper.updateStatus(collect.getId(), Status.NORMAL.getCode());
        }
    }

    @Override
    public void delete(Long id, Integer status) {
        collectMapper.updateStatus(id, status);
    }

    @Override
    public CollectParam findById(Long id) {
        return new CollectParam().compat(collectMapper.selectByPrimaryKey(id));
    }

    @Override
    public List<CollectParam> findByCusIdAndStatus(Long cusId, Integer status) {
        return new CollectConvertBo().adapter(collectMapper.selectByCusIdAndStatus(cusId,status));
    }
}
