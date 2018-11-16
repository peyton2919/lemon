package cn.peyton.spring.inf;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;

/**
 * <h3>Controller 扩展接口 </h3>
 * <pre>
 *     参数K T V 用法
 *     K 表示 主键数据 类型
 *     T 表示 入参时验证用的对象[用在页面的param]
 *     有二个方法:
 *     <b>1.分页 查找 全部对象</b>
 *          JsonData list(PageQuery page);
 *     <b>2.关键字 模糊分页查找</b>
 *          JsonData search(String keyword, PageQuery page);
 * </pre>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.inf.IControllerExtension.java
 * @createDate: 2018/9/13 14:05
 * @version: 1.0.0
 * </pre>
 */
public interface IControllerExtension<K,T> {

    /**
     * <h4>分页 查找 全部对象</h4>
     * @param page 分页对象
     * @return Json对象
     */
    JsonData list(PageQuery page);

    /**
     * <h4>关键字 模糊分页查找 </h4>
     * @param keyword 关键字
     * @param page 分页对象
     * @return Json对象
     */
    JsonData search(String keyword, PageQuery page);
}
