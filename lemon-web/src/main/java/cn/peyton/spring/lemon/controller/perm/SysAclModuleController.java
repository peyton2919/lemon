package cn.peyton.spring.lemon.controller.perm;

import cn.peyton.spring.permission.dto.AclModuleLevelDto;
import cn.peyton.spring.permission.param.AclModuleParam;
import cn.peyton.spring.permission.service.SysAclModuleService;
import cn.peyton.spring.permission.service.impl.SysTreeServiceImpl;
import cn.peyton.spring.common.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>权限模块 Controller 类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/20 9:10
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Controller
@RequestMapping("/sys/aclModule")
public class SysAclModuleController {

    @Resource
    private SysAclModuleService sysAclModuleService;
    @Resource
    private SysTreeServiceImpl sysTreeService;


    @RequestMapping("/acl.page")
    public ModelAndView page() {
        return new ModelAndView("perm/acl");
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveAclModule(AclModuleParam param) {
        sysAclModuleService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData updateAclModule(AclModuleParam param) {
        sysAclModuleService.update(param);
        return JsonData.success();
    }

    @RequestMapping("/tree.json")
    @ResponseBody
    public JsonData tree() {
        List<AclModuleLevelDto> list = sysTreeService.aclModuleTree();
        return JsonData.success(list);
    }

    @RequestMapping("/delete.json")
    @ResponseBody
    public JsonData deleteAclModule(@RequestParam("id")Integer id) {
        sysAclModuleService.delete(id);
        return JsonData.success();
    }
}
