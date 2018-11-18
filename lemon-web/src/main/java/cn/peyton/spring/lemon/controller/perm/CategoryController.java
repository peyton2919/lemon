package cn.peyton.spring.lemon.controller.perm;

import cn.peyton.spring.enums.Status;
import cn.peyton.spring.inf.IController;
import cn.peyton.spring.permission.entity.SysCategory;
import cn.peyton.spring.permission.param.CategoryParam;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.permission.service.SysCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>栏目 Controller 类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/18 15:09
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Controller
@RequestMapping("/sys/cate")
public class CategoryController implements IController<Integer,CategoryParam,SysCategory> {

	@Resource
	private SysCategoryService sysCategoryService;

    @Override
    public ModelAndView index() {
        return new ModelAndView("perm/category");
    }

    @RequestMapping("/category.page")
    public ModelAndView page() {
        return new ModelAndView("perm/category");
    }

    @Override
    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData save(CategoryParam param) {
        sysCategoryService.save(param);
        return JsonData.success();
    }

    @Override
    @RequestMapping("/delete.json")
    @ResponseBody
    public JsonData delete(@RequestParam("id") Integer id) {
        sysCategoryService.updateStatus(id, Status.DELETE.getCode());
        return JsonData.success();
    }

    @Override
    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData update(CategoryParam param) {
        sysCategoryService.update(param);
        return JsonData.success();
    }


    @RequestMapping(value = "/list.json")
    @ResponseBody
    public JsonData list(PageQuery page) {
        Map<String, Object> map = new HashMap<>();
        map.put("select",convertObj2Select(-1,false));
        map.put("page", sysCategoryService.findByAllAndPage(page));
        return JsonData.success(map);
    }


    @RequestMapping("/catalogues.json")
    @ResponseBody
    public JsonData catalogues(@RequestParam("type") Integer type,
                         @RequestParam(value = "page",defaultValue = "1",required = false)PageQuery page) {
        return JsonData.success(sysCategoryService.findByTypeAndPage(type,page));
    }
    @RequestMapping("/search.json")
    @ResponseBody
    public JsonData search(@RequestParam("name")String likeName,@RequestParam("type")Integer type, PageQuery page) {
        if (type < 0 || type > 3) {
            type = null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("select",convertObj2Select(-1,false));
        map.put("page", sysCategoryService.findSearchByLikeName(likeName,type,page));
        return JsonData.success(map);
    }


    @PostMapping("/detail.json")
    @ResponseBody
    public JsonData detail(@RequestParam("id") Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("category", sysCategoryService.findById(id));
        map.put("select", convertObj2Select(-1, true));
        return JsonData.success(map);
    }

    @PostMapping("/select.json")
    @ResponseBody
    public JsonData select(@RequestParam("parentId") Integer parentId,@RequestParam("isSelect") boolean isSelect) {
        return JsonData.success(convertObj2Select(parentId,isSelect));
    }

    /**
     * <h4>根据栏目父编号 查找</h4>
     * <pre>
     *     只查找3个字段[id,name,parentId]
     * </pre>
     * @param parentId 父编号 为-1时查找全部
     * @param isSelect 为true 查找下拉框[只查找状态可用]，否则 [查找状态可用和不可用]
     * @return
     */
    private  Map<Integer, CategoryParam> convertObj2Select(Integer parentId,boolean isSelect) {
        List<CategoryParam> categoryInfoList = sysCategoryService.findByParentId(parentId,isSelect);
        int size = categoryInfoList.size();
        Map<Integer, CategoryParam> categoryInfoMap = new HashMap<Integer, CategoryParam>();
        for (int i = 0; i < size; i++) {
            CategoryParam info = categoryInfoList.get(i);
            if (info.getParentId() == 0) {
                categoryInfoMap.put(info.getId(),info);
                for (int j = 0; j < size; j++) {
                    CategoryParam childInfo = categoryInfoList.get(j);
                    if (info.getId().equals(childInfo.getParentId())) {
                        categoryInfoMap.put(childInfo.getId(), childInfo);
                    }
                }
            }
        }
        return categoryInfoMap;
    }

}
