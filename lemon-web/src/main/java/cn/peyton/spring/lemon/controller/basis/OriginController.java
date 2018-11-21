package cn.peyton.spring.lemon.controller.basis;

import cn.peyton.spring.basis.entity.Origin;
import cn.peyton.spring.basis.param.OriginParam;
import cn.peyton.spring.basis.service.OriginService;
import cn.peyton.spring.inf.IController;
import cn.peyton.spring.inf.IControllerDetail;
import cn.peyton.spring.inf.IControllerExtension;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * <h3>产地 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 09:16:50
 * @version 1.0.0
 * </pre>
*/
@Controller
public class OriginController implements IController<Integer,OriginParam,Origin>,
        IControllerExtension<Integer,OriginParam>,IControllerDetail<Integer> {

	@Resource
	private OriginService originInfoService;

    @Override
    @RequestMapping("/sys/origin/origin.page")
    public ModelAndView index() {
        return new ModelAndView("basis/origin");
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/origin/save.json")
    public JsonData save(OriginParam param) {
        originInfoService.save(param);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/origin/delete.json")
    public JsonData delete(Integer id) {
        originInfoService.delete(id);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/origin/update.json")
    public JsonData update(OriginParam param) {
        originInfoService.update(param);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/origin/detail.json")
    public JsonData detail(Integer id) {
        return JsonData.success(originInfoService.findById(id));
    }

    @Override
    @ResponseBody
    @RequestMapping("/origin/list.json")
    public JsonData list(PageQuery page) {
        return JsonData.success(originInfoService.findByAll(page));
    }

    @Override
    @ResponseBody
    @RequestMapping("/origin/search.json")
    public JsonData search(String keyword, PageQuery page) {
        return JsonData.success(originInfoService.findLikeByKeyword(keyword,page));
    }
}
