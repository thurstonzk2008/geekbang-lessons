package org.geektimes.projects.user.consistentHash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhuhk
 * @create 2020-07-06 7:06 下午
 * @Version 1.0
 **/
public class HashUtil {
    private static MessageDigest md5Digist;
    private static final char[]  hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    static {
        try {
            md5Digist = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /*
     * 构造md5 String
     * @param key
     * @return
     */
    public static String md5(String key) {
        if (key == null) {
            key = "";
        }
        try {
            MessageDigest messageDigest = (MessageDigest) md5Digist.clone();
            messageDigest.update(key.getBytes());
            byte[] b = messageDigest.digest();
            char[] charArr = new char[32];
            for (int i = 0; i < b.length; i++) {
                charArr[i * 2] = hex[b[i] >>> 4 & 0xF];
                charArr[i * 2 + 1] = hex[b[i] & 0xF];
            }
            return new String(charArr);

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("md5:" + e,e);
        }

    }

    /**
     * 使用MD5散列的hash code
     *
     * @param key
     * @return
     */
    public static int md5HashCode(String key) {
        md5Digist.reset();
        md5Digist.update(key.getBytes());
        byte[] b = md5Digist.digest();
        int rv = ((int) (b[3] & 0xFF) << 24) | ((int) (b[2] & 0xFF) << 16) | ((int) (b[1] & 0xFF) << 8) | (b[0] & 0xFF);
        return rv > 0 ? rv : -rv;
    }
}
