package cn.peyton.spring.def;

import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.util.Lists;

import java.util.List;

/**
 * <h3>业务对象 公共 抽象类 .</h3>
 * <pre>
 *     参数P T 用法
 *     P 表示 入参时验证用的对象[页面上用的param对象]
 *     T 表示 查找出来 的对象[与数据库表对应]
 * </pre>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.def.BaseConvertBo.java
 * @createDate: 2018/9/13 12:24
 * @version: 1.0.0
 * </pre>
 */
public abstract class BaseConvertBo<P,T> {
    /** 要返回的集合 */
//    protected List<P> params;
    /**
    * <h4>T 对象转成 P 对象<h4>
    * @param info 对象
    * @return P 对象
    */
    public abstract P compat(T info);

    /**
     * <h4>数据 转换</h4>
     * @param list 集合
     * @return 有数据 为true
     */
    public List<P> adapter(List<T> list) {
        List<P> params = Lists.newArrayList();
        if (CheckedUtil.isNotEmptyList(list)) {
            for (T t : list) {
                params.add(compat(t));
            }
        }
        return params;
    }

}
