package cn.peyton.spring.lemon.controller.usergroup;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.inf.IController;
import cn.peyton.spring.inf.IControllerChange;
import cn.peyton.spring.inf.IControllerExtension;
import cn.peyton.spring.usergroup.entity.CustomerGrade;
import cn.peyton.spring.usergroup.param.CustomerGradeParam;
import cn.peyton.spring.usergroup.service.CustomerGradeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h3>客户等级 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:28:50
 * @version 1.0.0
 * </pre>
*/
@Controller
public class CustomerGradeController  implements IController<Integer,CustomerGradeParam,CustomerGrade>,
        IControllerExtension<Integer,CustomerGradeParam>,IControllerChange<Integer>{

	@Resource
	private CustomerGradeService customerGradeService;

    @Override
    @RequestMapping("/sys/cugr/customergrade.page")
    public ModelAndView index() {
        return new ModelAndView("cus/customergrade");
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/cugr/save.json")
    public JsonData save(CustomerGradeParam param) {
        customerGradeService.save(param);
        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/cugr/delete.json")
    public JsonData delete(Integer customerGradeId) {
        //todo 删除前判断

        return JsonData.success();
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/cugr/update.json")
    public JsonData update(CustomerGradeParam param) {
        customerGradeService.update(param);
        return JsonData.success();
    }

    @Override
    @RequestMapping("/sys/cugr/change.json")
    @ResponseBody
    public JsonData change(@RequestParam(name = "customerGradeId",required = false,defaultValue = "") Integer customerGradeId){
        return JsonData.success( customerGradeService.findById(customerGradeId));
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/cugr/list.json")
    public JsonData list(PageQuery page) {
        return JsonData.success(customerGradeService.findByAll(page));
    }

    @Override
    @ResponseBody
    @RequestMapping("/sys/cugr/search.json")
    public JsonData search(String keyword, PageQuery page) {
        return JsonData.success(customerGradeService.findLikeByKeyword(keyword,page));
    }
}
