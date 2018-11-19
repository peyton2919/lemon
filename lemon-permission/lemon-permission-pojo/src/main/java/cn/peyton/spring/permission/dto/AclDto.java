package cn.peyton.spring.permission.dto;

import cn.peyton.spring.permission.entity.SysAcl;
import org.springframework.beans.BeanUtils;

/**
 * <h3>权限 传递层 实体类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/19 11:45
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class AclDto extends SysAcl{

    /**  是否默认选中 默认 不选中 */
    private boolean checked = false;
    /** 是否有权限操作  默认 没有权限操作 */
    private boolean hasAcl = false;

    /**
     * <h4>SysAcl 适配 AclDto</h4>
     * @param acl 权限对象
     * @return  AclDto对象
     */
    public static AclDto adapt(SysAcl acl) {
        AclDto dto = new AclDto();
        BeanUtils.copyProperties(acl, dto);
        return dto;
    }

    //================================== GET AND SET =======================================//

    /**
     * @return 是否默认选中 默认 不选中
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * @param checked 是否默认选中 默认 不选中
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    /**
     * @return 是否有权限操作  默认 没有权限操作
     */
    public boolean isHasAcl() {
        return hasAcl;
    }

    /**
     * @param hasAcl 是否有权限操作  默认 没有权限操作
     */
    public void setHasAcl(boolean hasAcl) {
        this.hasAcl = hasAcl;
    }
}