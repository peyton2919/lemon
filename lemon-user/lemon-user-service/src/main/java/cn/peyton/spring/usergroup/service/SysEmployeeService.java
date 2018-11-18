package cn.peyton.spring.usergroup.service;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.usergroup.param.EmployeeParam;

import java.util.List;

/**
 * <h3>员工 Service 接口 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 16:25
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface SysEmployeeService{

    /**
     * <h4>添加对象</h4>
     * @param t 对象
     */
    void save(EmployeeParam t);

    /**
     * <h4>更新对象</h4>
     * @param t 对象
     */
    void update(EmployeeParam t);
    /**
     * <h4>根据主键删除对象</h4>
     * @param k 主键
     */
    void delete(Long k);
    /**
     * <h4>根据主键查找对象</h4>
     * @param k 主键
     * @return 对象
     */
    EmployeeParam findById(Long k);

    /**
     * <h4>查找对象集合</h4>
     * @param page 分页对象
     * @return 对象集合
     */
    PageResult<EmployeeParam> findByAllAndPage(PageQuery page);
    /**
     * <h4>根据部门编号 查找 员工集合</h4>
     * @param deptId 部门编号
     * @param page 分页查找
     * @return
     */
    PageResult<EmployeeParam> findByDeptId(Integer deptId, PageQuery page);

    /**
     * <h4>更新状态</h4>
     * @param id 编号
     * @param status 状态
     * @return 受影响行数
     */
    int updateStatus(Long id, int status);
    /**
     * <h4>根据登录名或邮箱 查找 对象</h4>
     * @param keyword 关键字[登录名、邮箱]
     * @return 对象
     */
    EmployeeParam findByKeyword(String keyword);
    /**
     * <h4>查找对象集合</h4>
     * @return 对象集合
     */
    List<EmployeeParam> findByAll();
}
