package cn.peyton.spring.lemon.controller.usergroup;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.usergroup.bo.EmployeeBo;
import cn.peyton.spring.usergroup.entity.SysEmployee;
import cn.peyton.spring.usergroup.param.EmployeeParam;
import cn.peyton.spring.usergroup.service.SysEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * <h3>员工 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/17 14:32:57
 * @version 1.0.0
 * </pre>
*/
@Controller
@RequestMapping("/sys/emp")
public class EmployeeController {

	@Resource
	private SysEmployeeService sysEmployeeService;

    public ModelAndView index() {
        return null;
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public JsonData list(@RequestParam("deptId")Integer deptId, PageQuery pageQuery) {

        return JsonData.success(sysEmployeeService.findByDeptId(deptId,pageQuery));
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData<EmployeeParam> save(EmployeeParam employeeParam) {
        sysEmployeeService.save(employeeParam);
        return JsonData.success();
    }

    @RequestMapping("/delete.json")
    @ResponseBody
    public JsonData<EmployeeParam> delete(@RequestParam("id") Long id) {
        sysEmployeeService.updateStatus(id, Status.DELETE.getCode());
        return JsonData.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData<EmployeeParam> update(EmployeeParam employeeParam) {
        sysEmployeeService.update(employeeParam);
        return JsonData.success();
    }

    @RequestMapping("/detail.json")
    @ResponseBody
    public JsonData detail(@RequestParam("employeeId") long employeeId) {
        return JsonData.success(sysEmployeeService.findById(employeeId));
    }

}
