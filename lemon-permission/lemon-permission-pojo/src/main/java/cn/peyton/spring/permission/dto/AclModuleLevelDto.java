package cn.peyton.spring.permission.dto;

import cn.peyton.spring.permission.entity.SysAclModule;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>权限模块 传递层 实体类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/19 11:44
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class AclModuleLevelDto extends SysAclModule{
    /** 权限模块 传递层 集合 */
    private List<AclModuleLevelDto> aclModuleList = new ArrayList<>();
    /** 权限 传递层 集合 */
    private List<AclDto> aclList = new ArrayList<>();

    /**
     * <h4>SysAclModule 适配 AclModuleLevelDto</h4>
     * @param aclModule SysAclModule 对象
     * @return AclModuleLevelDto 对象
     */
    public static AclModuleLevelDto adapt(SysAclModule aclModule) {
        AclModuleLevelDto dto = new AclModuleLevelDto();
        BeanUtils.copyProperties(aclModule, dto);
        return dto;
    }

    //================================== GET AND SET =======================================//

    /**
     * @return 权限模块 传递层 集合
     */
    public List<AclModuleLevelDto> getAclModuleList() {
        return aclModuleList;
    }

    /**
     * @param aclModuleList 权限模块 传递层 集合
     */
    public void setAclModuleList(List<AclModuleLevelDto> aclModuleList) {
        this.aclModuleList = aclModuleList;
    }

    /**
     * @return 权限 传递层 集合
     */
    public List<AclDto> getAclList() {
        return aclList;
    }

    /**
     * @param aclList 权限 传递层 集合
     */
    public void setAclList(List<AclDto> aclList) {
        this.aclList = aclList;
    }
}
