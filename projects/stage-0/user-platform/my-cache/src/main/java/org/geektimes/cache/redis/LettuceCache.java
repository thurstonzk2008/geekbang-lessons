package org.geektimes.cache.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.codec.ByteArrayCodec;
import io.lettuce.core.codec.RedisCodec;
import org.geektimes.cache.AbstractCache;
import org.geektimes.cache.ExpirableEntry;
import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;

import javax.cache.CacheException;
import javax.cache.CacheManager;
import javax.cache.configuration.Configuration;
import java.io.*;
import java.util.Set;

public class LettuceCache<K , V > extends AbstractCache<K, V> {

    private final RedisClient redisClient;
    private final StatefulRedisConnection<K, V> connection;
    private RedisCodecLettuceFactory redisCodecLettuceFactory = null;
    private RedisCommands<K, V> syncCommands = null;

    public LettuceCache(CacheManager cacheManager, String cacheName,
                        Configuration<K, V> configuration, RedisClient redisClient) {
        super(cacheManager, cacheName, configuration);
        this.redisClient = redisClient;
        redisCodecLettuceFactory = new RedisCodecLettuceFactory(configuration);
        connection = this.redisClient.connect(redisCodecLettuceFactory.getRedisCodec());
        syncCommands = connection.sync();

    }

    @Override
    protected boolean containsEntry(K key) throws CacheException, ClassCastException {

        return syncCommands.exists(key) > 0;

    }

    @Override
    protected ExpirableEntry<K, V> getEntry(K key) throws CacheException, ClassCastException {
        return getEntry(key);
    }

//    protected ExpirableEntry<K, V> getEntry(byte[] keyBytes) throws CacheException, ClassCastException {
//        byte[] valueBytes = jedis.get(keyBytes);
//        return ExpirableEntry.of(deserialize(keyBytes), deserialize(valueBytes));
//    }

    @Override
    protected void putEntry(ExpirableEntry<K, V> entry) throws CacheException, ClassCastException {
      syncCommands.set(entry.getKey(), entry.getValue());
    }

    @Override
    protected ExpirableEntry<K, V> removeEntry(K key) throws CacheException, ClassCastException {

        ExpirableEntry<K, V> oldEntry = getEntry(key);
        syncCommands.del(key);
        return oldEntry;
    }

    @Override
    protected void clearEntries() throws CacheException {
        // TODO
    }


    @Override
    protected Set<K> keySet() {
        // TODO
        return null;
    }

    @Override
    protected void doClose() {
        connection.close();
        this.redisClient.shutdown();
    }

//    // 是否可以抽象出一套序列化和反序列化的 API
//    private byte[] serialize(Object value) throws CacheException {
//        byte[] bytes = null;
//        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)
//        ) {
//            // Key -> byte[]
//            objectOutputStream.writeObject(value);
//            bytes = outputStream.toByteArray();
//        } catch (IOException e) {
//            throw new CacheException(e);
//        }
//        return bytes;
//    }
//
//    private <T> T deserialize(byte[] bytes) throws CacheException {
//        if (bytes == null) {
//            return null;
//        }
//        T value = null;
//        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
//             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)
//        ) {
//            // byte[] -> Value
//            value = (T) objectInputStream.readObject();
//        } catch (Exception e) {
//            throw new CacheException(e);
//        }
//        return value;
//    }

}
