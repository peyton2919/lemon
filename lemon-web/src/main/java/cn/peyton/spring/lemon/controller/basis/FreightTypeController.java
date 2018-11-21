package cn.peyton.spring.lemon.controller.basis;

import cn.peyton.spring.basis.entity.FreightType;
import cn.peyton.spring.basis.param.FreightTypeParam;
import cn.peyton.spring.basis.service.FreightTypeService;
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
 * <h3>货运类型 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/10 08:46:03
 * @version 1.0.0
 * </pre>
*/
@Controller
public class FreightTypeController implements IController<Integer,FreightTypeParam,FreightType>{

	@Resource
	private FreightTypeService freightTypeService;

    @Override
    @RequestMapping("/sys/ft/freighttype.page")
    public ModelAndView index() {
        return new ModelAndView("basis/freighttype");
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/ft/save.json")
    public JsonData save(FreightTypeParam param) {
        freightTypeService.save(param);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/ft/delete.json")
    public JsonData delete(Integer id) {
        freightTypeService.delete(id);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/ft/update.json")
    public JsonData update(FreightTypeParam param) {
        freightTypeService.update(param);
        return JsonData.success();
    }
    @ResponseBody
    @RequestMapping("/ft/detail.json")
    public JsonData detail(@RequestParam("id") Integer id) {
        FreightTypeParam param = freightTypeService.findById(id);
        return JsonData.success(param);
    }
    @ResponseBody
    @RequestMapping("/ft/list.json")
    public JsonData list(PageQuery page) {
        PageResult<FreightTypeParam> freightTypes = freightTypeService.findByAll(page);
        return JsonData.success(freightTypes);
    }
    @ResponseBody
    @RequestMapping("/ft/search.json")
    public JsonData findLikeByKeyword(@RequestParam("keyword") String keyword,PageQuery page) {
        PageResult<FreightTypeParam> freightTypes = freightTypeService.findLikeByKeywordAndPage(keyword, page);
        return JsonData.success(freightTypes);
     }
}
