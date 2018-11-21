package cn.peyton.spring.lemon.controller.basis;

import cn.peyton.spring.basis.entity.Warehouse;
import cn.peyton.spring.basis.param.WarehouseParam;
import cn.peyton.spring.basis.service.WarehouseInfoService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.inf.IController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * <h3>仓库 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/10 16:14:27
 * @version 1.0.0
 * </pre>
*/
@Controller
public class WarehouseController implements IController<Integer,WarehouseParam,Warehouse> {

	@Resource
	private WarehouseInfoService warehouseInfoService;
    @Override
    @RequestMapping("/sys/wh/warehouse.page")
    public ModelAndView index() {

        return new ModelAndView("basis/warehouse");
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/wh/save.json")
    public JsonData save(WarehouseParam param) {
        warehouseInfoService.save(param);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/wh/delete.json")
    public JsonData delete(Integer id) {
        warehouseInfoService.delete(id);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/wh/update.json")
    public JsonData update(WarehouseParam param) {
        warehouseInfoService.update(param);
        return JsonData.success();
    }
    @ResponseBody
    @RequestMapping("/wh/detail.json")
    public JsonData detail(@RequestParam("id") Integer id) {
        WarehouseParam param = warehouseInfoService.findById(id);
        return JsonData.success(param);
    }
    @ResponseBody
    @RequestMapping("/sys/wh/list.json")
    public JsonData list(PageQuery page) {
        PageResult<WarehouseParam> warehouseParams = warehouseInfoService.findByAll(page);
        return JsonData.success(warehouseParams);
    }
    @ResponseBody
    @RequestMapping("/sys/wh/search.json")
    public JsonData findLikeByKeyword(@RequestParam("keyword") String keyword,PageQuery page) {
        PageResult<WarehouseParam> warehouseParams = warehouseInfoService.findLikeByKeywordAndPage(keyword, page);
        return JsonData.success(warehouseParams);
    }
}
