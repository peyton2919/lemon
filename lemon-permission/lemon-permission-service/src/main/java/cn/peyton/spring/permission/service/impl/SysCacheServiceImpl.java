package cn.peyton.spring.permission.service.impl;

import cn.peyton.spring.permission.service.SysCacheService;
import cn.peyton.spring.constant.Constants;
import cn.peyton.spring.permission.service.redis.RedisPool;
import cn.peyton.spring.util.JsonMapper;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;

import javax.annotation.Resource;

/**
 * <h3>Redis 类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-19 20:09
 * @version: 1.0.0
 * </pre>
 */
@Service("sysCacheService")
public class SysCacheServiceImpl implements SysCacheService{

    private Logger log = LoggerFactory.getLogger(SysCacheServiceImpl.class);

    @Resource(name = "redisPool")
    private RedisPool redisPools;

    /**
     * <h4>保存缓存</h4>
     * @param toSaveValue 要保存的值
     * @param timeoutSeconds 超时
     * @param prefix 前缀
     */
    @Override
    public void saveCache(String toSaveValue, int timeoutSeconds, Constants prefix) {
        saveCache(toSaveValue,timeoutSeconds,prefix,"");
    }

    /**
     * <h4>保存缓存</h4>
     * @param toSaveValue 要保存的值
     * @param timeoutSeconds 超时
     * @param prefix 前缀
     * @param keys 多个key值
     */
    @Override
    public void saveCache(String toSaveValue, int timeoutSeconds, Constants prefix,String... keys) {
        if (toSaveValue == null) {
            return;
        }
        ShardedJedis shardedJedis = null;
        try {
            String cacheKey = generateCacheKey(prefix, keys);
            shardedJedis = redisPools.instance();
            shardedJedis.setex(cacheKey, timeoutSeconds, toSaveValue);
        } catch (Exception e) {
            log.error("[SysCacheServiceImpl] 保存缓存异常,prefix: {} , keys: {} ,Exception: {} ",prefix.name(), JsonMapper.obj2String(keys), e);
        }finally {
            redisPools.safeClose(shardedJedis);
        }
    }

    /**
     * <h4>获取缓存</h4>
     * @param prefix 前缀
     * @param keys 多个key值
     * @return 值
     */
    @Override
    public String getFromCache(Constants prefix , String... keys) {
        ShardedJedis shardedJedis = null;
        String cacheKey = generateCacheKey(prefix, keys);
        try {
            shardedJedis = redisPools.instance();
            return shardedJedis.get(cacheKey);
        } catch (Exception e) {
            log.error("[SysCacheServiceImpl] 获取缓存异常,prefix: {} , keys: {} ,Exception: {} ",prefix.name(),JsonMapper.obj2String(keys), e);
            return null;
        }finally {
            redisPools.safeClose(shardedJedis);
        }

    }

    private String generateCacheKey(Constants prefix, String... keys) {
        String key = prefix.name();
        if (keys != null && keys.length > 0) {
            key += "_" + Joiner.on("_").join(keys);
        }
        return key;
    }


}
