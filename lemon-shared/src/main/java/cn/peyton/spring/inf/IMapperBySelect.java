package cn.peyton.spring.inf;

import java.util.List;

/**
 * <h3>下拉框 Mapper 接口 .</h3>
 * <pre>
 *     <b style= "color:red;">T 为对象</b>
 *     <b>1.查找 全部适用 下拉框,正常情况下只返回[编号,名称]</b>
 *     List<T> selectBySelect();
 * </pre>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.inf.IMapperByAll.java
 * @createDate: 2018/9/13 10:18
 * @version: 1.0.0
 * </pre>
 */
public interface IMapperBySelect<T> {
    /**
     * <h4>查找 全部适用 下拉框</h4>
     * <pre>
     *     正常情况下只返回[编号,名称]
     * </pre>
     * @return 集合对象
     */
    List<T> selectBySelect();
}
