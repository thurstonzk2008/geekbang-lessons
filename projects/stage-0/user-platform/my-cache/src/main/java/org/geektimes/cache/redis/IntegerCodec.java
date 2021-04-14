package org.geektimes.cache.redis;

import io.lettuce.core.codec.RedisCodec;

import java.nio.ByteBuffer;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-04-14 9:13 上午
 * @Version 1.0
 **/
public class IntegerCodec implements RedisCodec {
    @Override
    public Integer decodeKey(ByteBuffer bytes) {
        return null;
    }

    @Override
    public Integer decodeValue(ByteBuffer bytes) {
        return null;
    }

    @Override
    public ByteBuffer encodeKey(Object key) {
        return null;
    }

    @Override
    public ByteBuffer encodeValue(Object value) {
        return null;
    }
}
