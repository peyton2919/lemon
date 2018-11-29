package cn.peyton.spring.mall.service.impl;

import cn.peyton.spring.mall.service.AttentionService;
import cn.peyton.spring.mall.dao.AttentionMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

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

}
