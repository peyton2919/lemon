package cn.peyton.spring.lemon.controller.basis;

import cn.peyton.spring.basis.entity.Shipping;
import cn.peyton.spring.basis.param.ShippingParam;
import cn.peyton.spring.basis.service.ShippingService;
import cn.peyton.spring.inf.IController;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.common.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * <h3>运输 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/11 14:34:58
 * @version 1.0.0
 * </pre>
*/
@Controller
public class ShippingController implements IController<Long,ShippingParam,Shipping>{

	@Resource
	private ShippingService shippingInfoService;


    @Override
    @RequestMapping("/sys/ft/shipping.page")
    public ModelAndView index() {
        return new ModelAndView("basis/shipping");
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/sp/save.json")
    public JsonData save(ShippingParam param) {
        shippingInfoService.save(param);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/sp/delete.json")
    public JsonData delete(Long id) {
        shippingInfoService.delete(id);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/sp/update.json")
    public JsonData update(ShippingParam param) {
        shippingInfoService.update(param);
        return JsonData.success();
    }
    @ResponseBody
    @RequestMapping("/sp/detail.json")
    public JsonData detail(@RequestParam("id") Long id) {
        ShippingParam param = shippingInfoService.findById(id);
        return JsonData.success(param);
    }
    @ResponseBody
    @RequestMapping("/sys/sp/list.json")
    public JsonData list(PageQuery page) {
        PageResult<ShippingParam> params = shippingInfoService.findByAll(page);
        return JsonData.success(params);
    }
    @ResponseBody
    @RequestMapping("/sys/sp/search.json")
    public JsonData findLikeByKeyword(@RequestParam("keyword") String keyword,PageQuery page) {
        PageResult<ShippingParam> params = shippingInfoService.findLikeByKeywordAndPage(keyword, page);
        return JsonData.success(params);
    }

}
