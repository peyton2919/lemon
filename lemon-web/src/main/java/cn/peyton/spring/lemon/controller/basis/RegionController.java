package cn.peyton.spring.lemon.controller.basis;

import cn.peyton.spring.basis.param.RegionParam;
import cn.peyton.spring.basis.service.RegionService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h3>地区 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:28:50
 * @version 1.0.0
 * </pre>
*/
@Controller
public class RegionController {

	@Resource
	private RegionService regionService;

    @RequestMapping("/sys/regi/region.page")
    public ModelAndView index() {
        return new ModelAndView("basis/region");
    }

	@RequestMapping("/sys/regi/save.json")
    @ResponseBody
    public JsonData save(RegionParam param) {
        regionService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/sys/regi/update.json")
    @ResponseBody
    public JsonData update(RegionParam param) {
        regionService.update(param);
        return JsonData.success();
    }

    @RequestMapping("/sys/regi/list.json")
    @ResponseBody
    public JsonData list(PageQuery page) {
        Map<String, Object> map = new ConcurrentHashMap<String, Object>();
        map.put("regionList", regionService.findByAll(page));
        map.put("regionMap", conventList2Map(regionService.findBySelect()));
        return JsonData.success(map);
    }

    @RequestMapping("/sys/regi/search.json")
    @ResponseBody
    public JsonData search(String keyword,PageQuery page) {
        Map<String, Object> map = new ConcurrentHashMap<String, Object>(2);
        map.put("regionList", regionService.findLikeByKeyword(keyword,page));
        map.put("regionMap", conventList2Map(regionService.findBySelect()));
        return JsonData.success(map);
    }

    @RequestMapping("/sys/regi/change.json")
    @ResponseBody
    public JsonData change(@RequestParam(name = "regionId",required = false,defaultValue = "") Long regionId){
        Map<String, Object> map = new ConcurrentHashMap<>(2);
        if (null != regionId && !"".equals(regionId)) {
            map.put("region", regionService.findById(regionId));
        }
        map.put("regionList", regionService.tree());
        return JsonData.success(map);
    }

    /**
     * <h4>List集合 转 Map集合</h4>
     * @param regionParams
     * @return
     */
    private Map<Long, RegionParam> conventList2Map(List<RegionParam> regionParams) {
        Map<Long, RegionParam> map = new ConcurrentHashMap<>();
        if (null != regionParams && regionParams.size() > 0) {
            for (RegionParam param : regionParams) {
                map.put(param.getId(), param);
            }
        }
        return map;
    }

}
