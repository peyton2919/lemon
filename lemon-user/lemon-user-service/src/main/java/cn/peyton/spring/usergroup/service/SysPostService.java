package cn.peyton.spring.usergroup.service;

import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.usergroup.entity.SysPost;
import cn.peyton.spring.usergroup.param.PostParam;

/**
 * <h3>职务 Service 接口 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 15:10
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface SysPostService {
    /**
     * <h4>添加</h4>
     * @param param 部门对象
     */
    void save(PostParam param);

    /**
     * <h4>更新</h4>
     * @param param 部门对象
     */
    void update(PostParam param);

    /**
     * <h4>根据编号 删除 对象</h4>
     * @param id 编号
     */
    void delete(Integer id);

    /**
     * <h4>查找 全部对象</h4>
     * @return 职务对象集合
     */
    PageResult<PostParam> findByAll();

}
