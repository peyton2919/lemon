package cn.peyton.spring.lemon.controller.mall;

import cn.peyton.spring.mall.service.AttentionService;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;

/**
 * <h3>关注[商品] Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/29 16:34:23
 * @version 1.0.0
 * </pre>
*/
@Controller
public class AttentionController {

	@Resource
	private AttentionService attentionService;

}
