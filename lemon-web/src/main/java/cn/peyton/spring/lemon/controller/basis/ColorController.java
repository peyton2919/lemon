package cn.peyton.spring.lemon.controller.basis;

import cn.peyton.spring.basis.entity.Color;
import cn.peyton.spring.basis.param.ColorParam;
import cn.peyton.spring.basis.service.ColorService;
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
import javax.servlet.http.HttpServletRequest;

/**
 * <h3>颜色 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 09:16:50
 * @version 1.0.0
 * </pre>
*/
@Controller
public class ColorController implements IController<Integer,ColorParam,Color>,
        IControllerExtension<Integer,ColorParam>,IControllerDetail<Integer>{

	@Resource
	private ColorService colorService;

    @Override
    @RequestMapping("/sys/color/color.page")
    public ModelAndView index() {

        return new ModelAndView("basis/color");
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/color/save.json")
    public JsonData save(ColorParam param) {
        colorService.save(param);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/color/delete.json")
    public JsonData delete(Integer id) {
        colorService.delete(id);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/color/update.json")
    public JsonData update(ColorParam param) {
        colorService.update(param);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/color/detail.json")
    public JsonData detail(Integer id) {
        return JsonData.success(colorService.findById(id));
    }

    @ResponseBody
    @RequestMapping("/color/obtaincolor.json")
    public JsonData obtainColor() {
        return JsonData.success(colorService.findBySelect());
    }

    @Override
    @ResponseBody
    @RequestMapping("/color/list.json")
    public JsonData list(PageQuery page) {
        return JsonData.success(colorService.findByAll(page));
    }

    @Override
    @ResponseBody
    @RequestMapping("/color/search.json")
    public JsonData search(String keyword, PageQuery page) {
        return JsonData.success(colorService.findLikeByKeyword(keyword,page));
    }
}
