package cn.peyton.spring.permission.service;

import cn.peyton.spring.constant.Constants;

/**
 * <h3>缓存 Service 接口 .</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-19 19:59
 * @version: 1.0.0
 * </pre>
 */
public interface SysCacheService {

    /**
     * <h4>保存缓存</h4>
     * @param toSaveValue 要保存的值
     * @param timeoutSeconds 超时(单位：秒)
     * @param prefix 前缀
     */
    void saveCache(String toSaveValue, int timeoutSeconds, Constants prefix);

    /**
     * <h4>保存缓存</h4>
     * @param toSaveValue 要保存的值
     * @param timeoutSeconds 超时(单位：秒)
     * @param prefix 前缀
     * @param keys 多个key值
     */
    void saveCache(String toSaveValue, int timeoutSeconds, Constants prefix, String... keys);

    /**
     * <h4>获取缓存</h4>
     * @param prefix 前缀
     * @param keys 多个key值
     * @return 值
     */
    String getFromCache(Constants prefix, String... keys);
}
