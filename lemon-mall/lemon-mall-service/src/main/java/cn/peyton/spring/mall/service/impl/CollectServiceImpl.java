package cn.peyton.spring.mall.service.impl;

import cn.peyton.spring.mall.service.CollectService;
import cn.peyton.spring.mall.dao.CollectMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

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

}
