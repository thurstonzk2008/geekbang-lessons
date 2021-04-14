week06
lettuce实现，复用了String编解码，实现了Integer的编码解码操作。其他类型没有实现（ByteBuffer的操作比较繁琐）
org.geektimes.cache.redis.LettuceCache
org.geektimes.cache.redis.LettuceCacheManager
org.geektimes.cache.redis.RedisCodecLettuceFactory
org.geektimes.cache.redis.IntegerCodec 2.序列化反序列化的抽象 stage-0/user-platform/my-cache/src/main/java/org/geektimes/cache/serialization
