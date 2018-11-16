package cn.peyton.spring.inf;

/**
 * <h3>更新状态 Service 接口 .</h3>
 * <pre>
 *     <b style= "color:red;">K 为主键</b>
 *     <b>1. 更新状态</b>
 *     int updateStatus(K id,Integer status);
 * </pre>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.inf.IServiceUpdateStatus.java
 * @createDate: 2018-09-22 0:23
 * @version: 1.0.0
 * </pre>
 */
public interface IServiceUpdateStatus<K> {

    /**
     * <h4>更新状态</h4>
     * @param id 主键
     * @param status 状态值
     * @return 受影响行数
     */
    void updateStatus(K id, Integer status);
}
