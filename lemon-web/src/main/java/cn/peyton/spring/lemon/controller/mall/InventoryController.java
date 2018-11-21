package cn.peyton.spring.lemon.controller.mall;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.mall.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * <h3>库存主 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/14 09:24:24
 * @version 1.0.0
 * </pre>
*/
@Controller
public class InventoryController {

	@Resource
	private InventoryService inventoryService;

	@RequestMapping("/sys/inve/inventory.page")
	public ModelAndView index() {
        return new ModelAndView("mall/inventory");
    }

    @RequestMapping("/sys/inve/list.json")
    @ResponseBody
    public JsonData list(PageQuery page) {
        return JsonData.success(inventoryService.findByAll(page));
    }

}
