package cn.peyton.spring.inf;

import cn.peyton.spring.common.JsonData;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h3>Controller接口 .</h3>
 * <pre>
 *     参数K T V 用法
 *     K 表示 主键数据 类型
 *     T 表示 入参时验证用的对象[用在页面的param]
 *     V 表示 查找出来 的对象[与数据库表对应]
 *     有4个方法:
 *     <b>1.入口页面</b>
 *          ModelAndView index();
 *     <b>2.添加对象</b>
 *          JsonData save(T param);
 *     <b>3.删除对象</b>
 *          JsonData delete(K id);
 *     <b>4.更新对象</b>
 *          JsonData update(T param);
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:20
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface IController<K,T,V> {

    /**
     * <h4>入口页面</h4>
     * @return ModelAndView对象
     */
    ModelAndView index();

    /**
     * <h4>添加</h4>
     * @param param 对象
     * @return JsonData 对象
     */
    JsonData save(T param);

    /**
     * <h4>删除</h4>
     * @param id 编号
     * @return JsonData 对象
     */
    JsonData delete(K id);

    /**
     * <h4>更新</h4>
     * @param param 对象
     * @return JsonData 对象
     */
    JsonData update(T param);
}
