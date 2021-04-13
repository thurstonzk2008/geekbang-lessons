package org.geektimes.cache.redis;

import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.codec.StringCodec;

import javax.cache.configuration.Configuration;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-04-13 7:06 下午
 * @Version 1.0
 **/
public class RedisCodecLettuceFactory<K, V> {
    private RedisCodec<K, ?> keyCodec = null;
    private RedisCodec<?, V> valueCodec = null;
    private Configuration<K, V> configuration = null;
    private static Map<Class<?>, RedisCodec> redisMap = new HashMap<>();

    static {
        redisMap.put(String.class, new StringCodec());
//        redisMap.put(Integer.class,new IntegerCodec());
//        redisMap.put(String.class,new StringCodec());
//        redisMap.put(String.class,new StringCodec());
//        redisMap.put(String.class,new StringCodec());
//        redisMap.put(String.class,new StringCodec());
//        redisMap.put(String.class,new StringCodec());
    }

    public RedisCodecLettuceFactory(Configuration<K, V> configuration) {
        this.configuration = configuration;
    }

    private RedisCodec getCodec(Class<?> clazz) {
        return redisMap.get(clazz);
    }

    public RedisCodec getRedisCodec() {
        keyCodec = getCodec(configuration.getKeyType());
        valueCodec = getCodec(configuration.getValueType());
        return RedisCodec.of(keyCodec, valueCodec);
    }
}
