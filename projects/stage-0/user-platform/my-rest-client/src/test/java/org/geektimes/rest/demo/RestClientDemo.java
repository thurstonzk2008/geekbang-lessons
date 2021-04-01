package org.geektimes.rest.demo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.geektimes.rest.user.User;

public class RestClientDemo {

    public static void main(String[] args) {
//        testGet();
        testPost();

    }

    private static void testPost() {
        User user = new User();
        user.setId(3L);
        user.setName("testName");
        MediaType mediaType = new MediaType("application","json","utf-8");
        Entity entity = Entity.entity(user,mediaType);
        Client client = ClientBuilder.newClient();
        Response response = client
                .target("http://127.0.0.1:8080/hello/world")      // WebTarget
                .request() // Invocation.Builder
                .post(entity);                                     //  Response

        String content = response.readEntity(String.class);

        System.out.println(content);
    }

    private static void testGet() {
        Client client = ClientBuilder.newClient();
        Response response = client
                .target("http://127.0.0.1:8080/hello/world")      // WebTarget
                .request() // Invocation.Builder
                .get();                                     //  Response

        String content = response.readEntity(String.class);

        System.out.println(content);
    }
}
