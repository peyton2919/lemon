package cn.peyton.spring.lemon.controller.basis;

import cn.peyton.spring.basis.entity.PaymentMode;
import cn.peyton.spring.basis.param.PaymentModeParam;
import cn.peyton.spring.basis.service.PaymentModeService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.inf.IController;
import cn.peyton.spring.inf.IControllerChange;
import cn.peyton.spring.inf.IControllerExtension;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * <h3>付款方式 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:28:50
 * @version 1.0.0
 * </pre>
*/
@Controller
public class PaymentModeController implements IController<Integer,PaymentModeParam,PaymentMode>,
        IControllerExtension<Integer,PaymentModeParam>, IControllerChange<Integer>{

	@Resource
	private PaymentModeService paymentModeService;

    @Override
    @RequestMapping("/sys/pamo/paymentmode.page")
    public ModelAndView index() {
        return new ModelAndView("basis/paymentmode");
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/pamo/save.json")
    public JsonData save(PaymentModeParam param) {
        paymentModeService.save(param);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/pamo/delete.json")
    public JsonData delete(Integer id) {

        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/pamo/update.json")
    public JsonData update(PaymentModeParam param) {
        paymentModeService.update(param);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/pamo/change.json")
    public JsonData change(@RequestParam(name = "paymentModeId",required = false,defaultValue = "") Integer paymentModeId) {
        if (null != paymentModeId && !"".equals(paymentModeId)) {
            return JsonData.success(paymentModeService.findById(paymentModeId));
        }
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/pamo/list.json")
    public JsonData list(PageQuery page) {

        return JsonData.success(paymentModeService.findByAll(page));
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/pamo/search.json")
    public JsonData search(String keyword, PageQuery page) {

        return JsonData.success(paymentModeService.findLikeByKeyword(keyword,page));
    }
}
