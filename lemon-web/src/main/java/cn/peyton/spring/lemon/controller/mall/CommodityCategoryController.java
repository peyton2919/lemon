package cn.peyton.spring.lemon.controller.mall;

import cn.peyton.spring.inf.IController;
import cn.peyton.spring.inf.IControllerDetail;
import cn.peyton.spring.inf.IControllerExtension;
import cn.peyton.spring.mall.entity.CommodityCategory;
import cn.peyton.spring.mall.param.CommodityCategoryParam;
import cn.peyton.spring.mall.service.CommodityCategoryService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h3>商品类目 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/14 11:25:12
 * @version 1.0.0
 * </pre>
*/
@Controller
public class CommodityCategoryController implements IController<Long,CommodityCategoryParam,CommodityCategory>,
            IControllerExtension<Long,CommodityCategoryParam>,IControllerDetail<Long>{

	@Resource
	private CommodityCategoryService commodityCategoryService;

    @Override
    @RequestMapping("/sys/coca/commoditycategory.page")
    public ModelAndView index() {
        return new ModelAndView("mall/commoditycategory");
    }

    @Override
    @RequestMapping("/sys/coca/save.json")
    @ResponseBody
    public JsonData save(CommodityCategoryParam param) {
        commodityCategoryService.save(param);
        return JsonData.success();
    }

    @Override
    @RequestMapping("/sys/coca/delete.json")
    @ResponseBody
    public JsonData delete(Long id) {
        commodityCategoryService.delete(id);
        return JsonData.success();
    }

    @Override
    @RequestMapping("/sys/coca/update.json")
    @ResponseBody
    public JsonData update(CommodityCategoryParam param) {
        commodityCategoryService.update(param);
        return JsonData.success();
    }
    @RequestMapping("/coca/tree.json")
    @ResponseBody
    public JsonData tree() {
        List<CommodityCategoryParam> tree = commodityCategoryService.tree();
        return JsonData.success(tree);
    }

    @Override
    @ResponseBody
    @RequestMapping("/coca/detail.json")
    public JsonData detail(Long id) {
        return JsonData.success(commodityCategoryService.findById(id));
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/coca/list.json")
    public JsonData list(PageQuery page) {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("commodityCategories", commodityCategoryService.findByAll(page));
        map.put("commodityCategorySelect", commodityCategoryService.findBySelect());
        return JsonData.success(map);
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/coca/search.json")
    public JsonData search(String keyword, PageQuery page) {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("commodityCategories", commodityCategoryService.findLikeByKeyword(keyword,page));
        map.put("commodityCategorySelect", commodityCategoryService.findBySelect());
        return JsonData.success(map);
    }
}
