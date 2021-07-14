//package com.example.javabasic.utils.redis;
//
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.redis.core.RedisOperations;
//import org.springframework.data.redis.core.SessionCallback;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
///**
// * @description: redis 同步锁
// */
//@Component
//public class SyncRedis implements InitializingBean {
//
//    private static final Logger log = LoggerFactory.getLogger(SyncRedis.class);
//    private static SyncRedis syncRedis = null;
//    private final int REDIS_KEY_EXPIRE_SECOND_2_MINUTE = 2;
//    private final String SYNC_LOCK_KEY_PREFIX = "sync_lock_key:";
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    public SyncRedis() {
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        syncRedis = this;
//    }
//
//    public static SyncRedis getSyncRedis() {
//        return syncRedis;
//    }
//
//    public Boolean lock(final String lockKey) {
//        if (StringUtils.isBlank(lockKey)) {
//            return false;
//        } else {
//            String key = "sync_lock_key:" + lockKey;
//            final String value = String.valueOf(System.currentTimeMillis());
//            SessionCallback<Boolean> sessionCallback = new SessionCallback<Boolean>() {
//                List<Object> exec = null;
//
//                public Boolean execute(RedisOperations operations) throws DataAccessException {
//                    operations.multi();
//                    SyncRedis.this.stringRedisTemplate.opsForValue().setIfAbsent(key, value);
//                    SyncRedis.this.stringRedisTemplate.expire(key, 30L, TimeUnit.SECONDS);
//                    this.exec = operations.exec();
//                    return this.exec.size() > 0 ? (Boolean) this.exec.get(0) : false;
//                }
//            };
//            return (Boolean) this.stringRedisTemplate.execute(sessionCallback);
//        }
//    }
//
//    public void unLock(String lockKey) {
//        try {
//            if (StringUtils.isNoneBlank(lockKey)) {
//                this.stringRedisTemplate.opsForValue().getOperations().delete("sync_lock_key:" + lockKey);
//            }
//        } catch (Exception var3) {
//            log.error("对[ {} ]解锁失败 error message:{}", lockKey, var3.getMessage());
//        }
//
//    }
//}
