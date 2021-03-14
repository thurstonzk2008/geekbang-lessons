package org.geektimes.projects.user.management;

import org.jolokia.client.J4pClient;
import org.jolokia.client.request.J4pReadRequest;
import org.jolokia.client.request.J4pReadResponse;

import java.util.Map;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-03-14 4:40 下午
 * @Version 1.0
 **/
public class JolokiaDemo {
    public static void main(String[] args) throws Exception {
        J4pClient j4pClient = new J4pClient("http://localhost:8080/jolokia");
        J4pReadRequest req = new J4pReadRequest("java.lang:type=Memory",
                "HeapMemoryUsage");
        J4pReadResponse resp = j4pClient.execute(req);
        Map<String, Long> vals = resp.getValue();
        long used = vals.get("used");
        long max = vals.get("max");
        int usage = (int) (used * 100 / max);
        System.out.println("Memory usage: used: " + used +
                " / max: " + max + " = " + usage + "%");
    }
}
