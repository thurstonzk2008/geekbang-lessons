package pers.cocoadel.learning.spring.cloud.bus.redis.message;

public class RedisMessage {
    private String clazz;

    private Object playLoad;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Object getPlayLoad() {
        return playLoad;
    }

    public void setPlayLoad(Object playLoad) {
        this.playLoad = playLoad;
    }

    @Override
    public String toString() {
        return "RedisMessage{" +
                "clazz='" + clazz + '\'' +
                ", playLoad=" + playLoad +
                '}';
    }
}
