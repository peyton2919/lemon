package cn.peyton.spring.common;

import cn.peyton.spring.log.LogUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * <h3>本地缓存的Token</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:48
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class TokenCache {

    /**  Token 前缀     */
    public static final String TOKEN_PREFIX = "token_";
    /**
     * 申明 静态的内存块 LRU 算法
     */
    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder()
            //设置缓存初始化容量
            .initialCapacity(1000)
            //缓存 最大容量当超过最大容量，在使用LRU算法移除
            .maximumSize(10000)
            //缓存 有效期为12个小时
            .expireAfterAccess(12, TimeUnit.HOURS)
            .build(new CacheLoader<String, String>() {
                //默认的数据 加载实现，当调用get取值的时候,如果key 没有对应的值, 就调用这个方法进行加载
                @Override
                public String load(String key) throws Exception {
                    return "null";
                }
            });

    /**
     * <h4>设置本地缓存</h4>
     * @param key 键
     * @param value 值
     */
    public static void set(String key, String value) {
        localCache.put(key, value);
    }

    /**
     * <h4>获取本地缓存 值</h4>
     * @param key 键
     * @return 值
     */
    public static String get(String key) {
        String value = null;
        try {
            value = localCache.get(key);
            if ("null".equals(value)) {
                return null;
            }
            return value;
        } catch (Exception e) {
            LogUtil.error("LocalCache 获取异常,key:{}",e.getMessage());
        }
        return null;
    }
}
