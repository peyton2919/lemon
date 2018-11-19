package cn.peyton.spring.lemon.controller.perm;

import cn.peyton.spring.permission.param.AclParam;
import cn.peyton.spring.permission.param.RoleParam;
import cn.peyton.spring.permission.service.SysAclService;
import cn.peyton.spring.permission.service.SysRoleService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import com.google.common.collect.Maps;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <h3>权限 Controller 类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/19 11:40
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Controller
@RequestMapping("/sys/acl")
public class SysAclController {

    @Resource
    private SysAclService sysAclService;
    @Resource
    private SysRoleService sysRoleService;

    @RequestMapping("/page.json")
    @ResponseBody
    public JsonData list(@Param("aclModuleId")Integer aclModuleId, PageQuery page) {

        return JsonData.success( sysAclService.findPageByAclModuleId(aclModuleId, page));
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveAcl(AclParam param) {
        sysAclService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData updateAcl(AclParam param) {
        sysAclService.update(param);
        return JsonData.success();
    }

    @RequestMapping("/acls.json")
    @ResponseBody
    public JsonData acls(@RequestParam("aclId") Integer aclId) {
        Map<String,Object> map = Maps.newHashMap();
        List<RoleParam> roleList = sysRoleService.findRoleListByAclId(aclId);
        map.put("roles", roleList);
        map.put("users",sysRoleService.findUserListByRoleList(roleList));
        return JsonData.success(map);
    }

}
