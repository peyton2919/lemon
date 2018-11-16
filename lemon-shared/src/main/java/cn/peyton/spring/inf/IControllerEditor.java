package cn.peyton.spring.inf;

import cn.peyton.spring.common.JsonData;

/**
 * <h3>Controller 编辑 接口 </h3>
 * <pre>
 *     参数K 用法
 *     K 表示 主键数据 类型
 *     有一个方法:
 *     <b>1.根据 主键 查找</b>
 *          JsonData editer(K id);
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:23
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface IControllerEditor<K> {
    /**
     * <h4>根据 主键 查找</h4>
     * @param id 主键
     * @return Json 对象
     */
    JsonData editer(K id);
}
