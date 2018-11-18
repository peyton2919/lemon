package cn.peyton.spring.usergroup.service;

import cn.peyton.spring.usergroup.dto.DeptLevelDto;
import cn.peyton.spring.usergroup.param.DeptParam;

import java.util.List;

/**
 * <h3>部门 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/17 09:15:49
 * @version 1.0.0
 * </pre>
*/
public interface SysDeptService {
    /**
     * <h4>保存</h4>
     * @param param 部门对象
     */
    void save(DeptParam param) ;

    /**
     * <h4>更新</h4>
     * @param param 部门对象
     */
    void update(DeptParam param);

    /**
     * <h4>删除</h4>
     * @param deptId 部门ID
     */
    void delete(int deptId);

    /**
     * <h4>部门树</h4>
     * @return 部门 传递层对象集合
     */
    List<DeptLevelDto> deptTree() ;
}
