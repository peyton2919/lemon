package cn.peyton.spring.lemon.controller.usergroup;

import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.usergroup.dto.DeptLevelDto;
import cn.peyton.spring.usergroup.param.DeptParam;
import cn.peyton.spring.usergroup.service.SysDeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>部门 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/17 09:15:49
 * @version 1.0.0
 * </pre>
*/
@Controller
@RequestMapping("/sys/dept")
public class DeptController {

	@Resource
	private SysDeptService sysDeptService;

    @RequestMapping("/dept.page")
    public ModelAndView page() {
        return new ModelAndView("emp/dept");
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData save(DeptParam param) {
        sysDeptService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/tree.json")
    @ResponseBody
    public JsonData tree() {
        List<DeptLevelDto> dtoList = sysDeptService.deptTree();
        return JsonData.success(dtoList);
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData update(DeptParam param) {
        sysDeptService.update(param);
        return JsonData.success();
    }

    @RequestMapping("/delete.json")
    @ResponseBody
    public JsonData delete(@RequestParam("id") Integer id) {
        sysDeptService.delete(id);
        return JsonData.success();
    }
}
