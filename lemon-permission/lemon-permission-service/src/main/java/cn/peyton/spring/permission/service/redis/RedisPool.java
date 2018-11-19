package cn.peyton.spring.permission.service.redis;

import cn.peyton.spring.log.LogUtil;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;

/**
 * <h3>Redis 池</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: perm
 * PackageName: cn.peyton.spring.perm.service.impl.RedisPool.java
 * CreateDate: 2018/7/6 16:42
 * Version: 1.0.0
 * </pre>
 */
@Service("redisPool")
public class RedisPool {

    @Resource(name = "shardedJedisPool")
    private ShardedJedisPool shardedJedisPool;

    public ShardedJedis instance() {
        return shardedJedisPool.getResource();
    }

    /**
     * <h4>安全关闭</h4>
     * @param shardedJedis
     */
    public void safeClose(ShardedJedis shardedJedis) {
        try {
            if (shardedJedis != null) {
                shardedJedis.close();
            }
        } catch (Exception e) {
            LogUtil.error("安全关闭Redis出异常 {}",e);
        }
    }
}
