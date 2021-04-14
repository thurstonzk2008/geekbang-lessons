package org.geektimes.cache.redis;

import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.codec.StringCodec;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;


/**
 * Integer的codec
 * 依靠StringCodec处理Integer，待修改
 *
 * @author zhuhk
 * @create 2021-04-14 9:13 上午
 * @Version 1.0
 **/
public class IntegerCodec implements RedisCodec {

    @Override
    public Integer decodeKey(ByteBuffer bytes) {
        return getInteger(bytes);
    }


    @Override
    public Integer decodeValue(ByteBuffer bytes) {
        return getInteger(bytes);
    }

    private Integer getInteger(ByteBuffer bytes) {
        return Integer.valueOf(new StringCodec(Charset.defaultCharset()).decodeKey(bytes));
    }

    @Override
    public ByteBuffer encodeKey(Object key) {
        return getByteBuffer(key);
    }


    @Override
    public ByteBuffer encodeValue(Object value) {
        return getByteBuffer(value);
    }

    private ByteBuffer getByteBuffer(Object key) {
        if (!(key instanceof Integer)) {
            throw new RuntimeException("key is not Integer");
        }
        return new StringCodec(Charset.defaultCharset()).encodeKey(key.toString());
    }


}
