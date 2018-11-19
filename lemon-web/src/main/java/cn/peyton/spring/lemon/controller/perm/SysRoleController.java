package cn.peyton.spring.lemon.controller.perm;

import cn.peyton.spring.permission.dto.AclModuleLevelDto;
import cn.peyton.spring.permission.entity.SysEmployee;
import cn.peyton.spring.permission.param.RoleParam;
import cn.peyton.spring.permission.service.*;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.usergroup.service.SysEmployeeService;
import cn.peyton.spring.util.StringUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <h3>角色 Controller 类</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: perm
 * PackageName: cn.peyton.spring.perm.controller.SysRoleController.java
 * CreateDate: 2018/6/30 8:39
 * Version: 1.0.0
 * </pre>
 */
@Controller
@RequestMapping("/sys/role")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysTreeService sysTreeService;
    @Resource
    private SysRoleAclService sysRoleAclService;
    @Resource
    private SysRoleUserService sysRoleUserService;
    @Resource
    private SysEmployeeService sysEmployeeService;

    @RequestMapping("/role.page")
    @ResponseBody
    public ModelAndView page() {

        return new ModelAndView("perm/role");
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveRole(RoleParam param) {
        sysRoleService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData updateRole(RoleParam param) {
        sysRoleService.update(param);
        return JsonData.success();
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public JsonData list() {
        return JsonData.success(sysRoleService.findByAll());
    }

    @RequestMapping("/roleTree.json")
    @ResponseBody
    public JsonData roleTree(@RequestParam("roleId") Integer roleId) {
        List<AclModuleLevelDto> aclModuleLevelDtos = sysTreeService.roleTree(roleId);
        return JsonData.success(aclModuleLevelDtos);
    }

    @RequestMapping("/changeAcls.json")
    @ResponseBody
    public JsonData changeAcls(@RequestParam("roleId") Integer roleId ,
                               @RequestParam(value = "aclIds",required = false,defaultValue = "") String aclIds) {
        List<Integer> aclList = StringUtil.splitToListInt(aclIds);
        sysRoleAclService.changeRoleAcls(roleId,aclList);
        return JsonData.success();
    }

    @RequestMapping("/users.json")
    @ResponseBody
    public JsonData users(@RequestParam("roleId") Integer roleId) {
        //todo 修改 user 为employee
        List<SysEmployee> selectedEmpList = sysRoleUserService.getListByRoleId(roleId);
        List<SysEmployee> allEmpList = sysEmployeeService.findByAll();
        List<SysEmployee> unselectedUserList = Lists.newArrayList();

        Set<Integer> selectedUserIdSet = selectedEmpList.stream()
                .map(sysEmployee -> sysEmployee.getId())
                .collect(Collectors.toSet());

        for (SysEmployee sysEmployee : allEmpList) {
            if (sysEmployee.getEmpStatus() == 1 && !selectedUserIdSet.contains(sysEmployee.getId())) {
                unselectedUserList.add(sysEmployee);
            }
        }
        Map<String,List<SysEmployee>> map = Maps.newHashMap();
        map.put("selected", selectedEmpList);
        map.put("unselected", unselectedUserList);
        return JsonData.success(map);
    }

    @RequestMapping("/changeUsers.json")
    @ResponseBody
    public JsonData changeUsers(@RequestParam("roleId") Integer roleId,
                                @RequestParam(value = "userIds",required = false,defaultValue = "")String userIds) {
        List<Integer> userIdList = StringUtil.splitToListInt(userIds);
        sysRoleUserService.changeRoleUsers(roleId,userIdList);
        return JsonData.success();
    }

}
