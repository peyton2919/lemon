package cn.peyton.spring.usergroup.dto;

import cn.peyton.spring.usergroup.entity.SysDept;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>部门 传递层 实体类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 12:45
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class DeptLevelDto extends SysDept {

    /** 部门 传递层 集合 */
    private List<DeptLevelDto> deptList = new ArrayList<>();

    /**
     * <h4>SysDept 适配 DeptLevelDto</h4>
     * @param dept SysDept 对象
     * @return DeptLevelDto 对象
     */
    public static DeptLevelDto adapt(SysDept dept) {
        DeptLevelDto dto = new DeptLevelDto();
        BeanUtils.copyProperties(dept,dto);
        return dto;
    }


    /**
     * @return 部门 传递层 集合
     */
    public List<DeptLevelDto> getDeptList() {
        return deptList;
    }

    /**
     * @param deptList 部门 传递层 集合
     */
    public void setDeptList(List<DeptLevelDto> deptList) {
        this.deptList = deptList;
    }
}
