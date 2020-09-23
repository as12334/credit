package so.wwb.lotterybox.cache;

import org.soul.commons.cache.CacheKey;
import org.soul.commons.cache.jedis.proxy.JedisClientProxy;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.SerializationTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.session.RedisSessionPrefix;
import redis.clients.util.SafeEncoder;

import java.io.Serializable;
import java.util.Set;

public class TokenCache {

    private static final Log LOG = LogFactory.getLog(TokenCache.class);

    private JedisClientProxy jedisClientProxy;

    public JedisClientProxy getJedisClientProxy() {
        return jedisClientProxy;
    }

    public void setJedisClientProxy(JedisClientProxy jedisClientProxy) {
        this.jedisClientProxy = jedisClientProxy;
    }

    /**
     * 默认缓存过期时间单位秒
     */
    private Integer expire;

    /**
     * key值的前缀
     */
    private String keyPrefix;

    public void doCache(String key, Serializable value) {
        if (StringTool.isBlank(key)) {
            LOG.warn("缓存数据的key值为空，不允许缓存.");
            return;
        }
        if (expire == null) {
            expire = this.getExpire();
            LOG.warn("缓存数据的key:{0},value:{1},expire为null,取默认过期时间为{2}进行缓存.", key, value, this.getExpire());
        }
        key = getActualKey(key);
        LOG.debug("存储.api.token:{0}", key);
        getJedisClientProxy().setex(key.getBytes(), expire, SerializationTool.serialize(value));
    }

    private String getActualKey(String key) {
        RedisSessionPrefix redisSessionPrefix = new RedisSessionPrefix(CommonContext.get());
        return keyPrefix + redisSessionPrefix.getPrefix() + key;
        //return keyPrefix+key;
    }

    public byte[] getCache(String key) {
        if (StringTool.isBlank(key)) {
            LOG.warn("获取缓存数据时传入的key值为空，直接return null.");
            return null;
        }
        byte[] bytes = getJedisClientProxy().get(getActualKey(key).getBytes());
        return bytes;
    }

    public <E extends Serializable> E getCache(String key, E e) {
        byte[] bytes = getCache(key);
        if (bytes != null)
            return (E) SerializationTool.deserialize(bytes);
        return null;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    /**
     * 删除Token
     *
     * @param userId
     */
    public void deleteToken(Integer userId) {
        if (userId == null) {
            LOG.error("UserId is null");
            return;
        }

        Set<String> keys = getUserActiveSessions(userId);
        if (keys != null && keys.size() > 0) {
            for (String key : keys) {
                getJedisClientProxy().del(key);
            }
        }
    }

    public Set<String> getUserActiveSessions(Integer userId) {
        return getActiveSessionKeys(userId + ":");
    }

    /**
     * 根据通配符获取活动会话Keys
     *
     * @param pattern
     * @return
     */
    private Set<String> getActiveSessionKeys(String pattern) {
        return getJedisClientProxy().keys(SafeEncoder.encode(CacheKey.getCacheKey(genPrefix(), pattern + "*")));
    }

    /**
     * 当前站点的前缀
     *
     * @return
     */
    public String genPrefix() {
        RedisSessionPrefix redisSessionPrefix = new RedisSessionPrefix(CommonContext.get());
        return keyPrefix + redisSessionPrefix.getPrefix();
    }
}