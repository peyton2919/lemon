package cn.peyton.spring.lemon.controller.mall;

import cn.peyton.spring.basis.service.OriginService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.lemon.controller.BasePicturePath;
import cn.peyton.spring.mall.param.CommodityParam;
import cn.peyton.spring.mall.service.CommodityCategoryService;
import cn.peyton.spring.mall.service.CommodityService;
import cn.peyton.spring.mall.service.CommoditySortService;
import cn.peyton.spring.util.PathUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h3>商品 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/23 21:44:35
 * @version 1.0.0
 * </pre>
*/
@Controller
public class CommodityController {

	@Resource
	private CommodityService commodityService;
	@Resource
    private OriginService originService;
	@Resource
    private CommoditySortService commoditySortService;
	@Resource
    private CommodityCategoryService commodityCategoryService;

	@RequestMapping("/sys/comm/change.page")
    public ModelAndView changeAdd(@RequestParam(name = "id",required = false,defaultValue = "") String id ,
                                  HttpServletRequest request) {
	    request.setAttribute("commodityId",id);
        return new ModelAndView("mall/commodity_add");
    }
    @RequestMapping("/sys/comm/detail.page")
    public ModelAndView changeDetail(@RequestParam(name = "id",required = false,value = "") String id ,
                                  HttpServletRequest request) {
	    request.setAttribute("commodityId",id);
        return new ModelAndView("mall/commodity_detail");
    }

    @RequestMapping("/sys/comm/commodity.page")
    public ModelAndView index() {
        return new ModelAndView("mall/commodity");
    }

    @RequestMapping("/sys/comm/save.json")
    @ResponseBody
    public JsonData save(CommodityParam param,HttpServletRequest request) {
	    //获取完整路径[商品图片路径]
        String path = PathUtil.getPath(BasePicturePath.IMG_PRODUCT,request);
        param.setCompletePath(path);
        param.setPrefixPath(BasePicturePath.IMG_PRODUCT);
        //主图480*480
        commodityService.save(param);
	    return JsonData.success();
    }

    @RequestMapping("/sys/comm/detail.json")
    @ResponseBody
    public JsonData detail(String id) {
        if (null == id || "".equals(id)) {
            return JsonData.success();
        }
        //todo
        //商品分类，商品产地，商品类目
        CommodityParam  commodity = commodityService.findById(id);
        if (commodity == null) {
            return JsonData.success();
        }

        return JsonData.success(commodityService.findById(id));

    }

    @RequestMapping("/sys/comm/update.json")
    @ResponseBody
    public JsonData update(CommodityParam param,HttpServletRequest request) {
        String path = PathUtil.getPath(BasePicturePath.IMG_PRODUCT,request);
        param.setCompletePath(path);
        param.setPrefixPath(BasePicturePath.IMG_PRODUCT);
        commodityService.update(param);
        return JsonData.success();
    }

    @RequestMapping("/sys/comm/delete.json")
    @ResponseBody
    public JsonData delete(String id) {
	    commodityService.updateStatus(id, Status.DELETE.getCode());
	    return JsonData.success();
    }
    @RequestMapping("/sys/comm/obtainmainimg.json")
    @ResponseBody
    public JsonData obtainMainImg(String id){
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("mainImg", commodityService.findMainImgById(id));
        return JsonData.success(map);
    }

    @RequestMapping("/sys/comm/list.json")
    @ResponseBody
    public JsonData list(PageQuery page) {
	    return JsonData.success(commodityService.findByAll(page));
    }

    @ResponseBody
    @RequestMapping("/sys/comm/search.json")
    public JsonData search(String keyword, PageQuery page) {
	    return JsonData.success(commodityService.findLikeByKeyword(keyword,page));
    }

    @RequestMapping("/sys/comm/data.json")
    @ResponseBody
    public JsonData data(@RequestParam(name = "id",required = false,defaultValue = "")String id) {
        return JsonData.success(getLoadData(id));
    }

    /**
     * <h4>获取加载时下拉框的数据</h4>
     * @return
     */
    private Map<String, Object> getLoadData(String id) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        if (null != id && !"".equals(id.trim())) {
            CommodityParam info = commodityService.findById(id);
            map.put("commodity", info);
        }
        map.put("originList", originService.findBySelect());
        map.put("commoditySortList", commoditySortService.findBySelect().toArray());
        map.put("commodityCategoryList", commodityCategoryService.findBySelect());
        return map;
    }

}
