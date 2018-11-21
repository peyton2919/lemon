package cn.peyton.spring.lemon.controller.mall;

import cn.peyton.spring.inf.IController;
import cn.peyton.spring.inf.IControllerDetail;
import cn.peyton.spring.inf.IControllerExtension;
import cn.peyton.spring.mall.entity.CommoditySort;
import cn.peyton.spring.mall.param.CommoditySortParam;
import cn.peyton.spring.mall.service.CommoditySortService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * <h3>商品分类 Controller 类 .</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.lemon.controller.mall.BrandController.java
 * @createDate: 2018-09-13 17:34
 * @version: 1.0.0
 * </pre>
 */
@Controller
public class CommoditySortController implements IController<Integer, CommoditySortParam, CommoditySort>,
        IControllerExtension<Integer, CommoditySortParam>,IControllerDetail<Integer> {

    @Resource
    private CommoditySortService commoditySortService;

    @Override
    @RequestMapping("/sys/coso/commoditysort.page")
    public ModelAndView index() {
        return new ModelAndView("mall/commoditysort");
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/coso/save.json")
    public JsonData save(CommoditySortParam param) {
        commoditySortService.save(param);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/coso/delete.json")
    public JsonData delete(Integer id) {
        commoditySortService.delete(id);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/coso/update.json")
    public JsonData update(CommoditySortParam param) {
        commoditySortService.update(param);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/coso/detail.json")
    public JsonData detail(Integer id) {
        return JsonData.success(commoditySortService.findById(id));
    }

    @Override
    @ResponseBody
    @RequestMapping("/coso/list.json")
    public JsonData list(PageQuery page) {
        return JsonData.success(commoditySortService.findByAll(page));
    }

    @Override
    @ResponseBody
    @RequestMapping("/coso/search.json")
    public JsonData search(String keyword, PageQuery page) {
        return JsonData.success(commoditySortService.findLikeByKeyword(keyword,page));
    }
}
