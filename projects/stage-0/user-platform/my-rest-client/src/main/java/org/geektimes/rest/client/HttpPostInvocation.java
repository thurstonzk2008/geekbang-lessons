/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.geektimes.rest.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geektimes.rest.core.DefaultResponse;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * post请求
 *
 * @Author zhuhk
 *
**/
class HttpPostInvocation implements Invocation {

    private final URI uri;

    private final URL url;

    private final MultivaluedMap<String, Object> headers;

    private Entity<?> entity = null;

    ExecutorService executorService = null;

    HttpPostInvocation(URI uri, MultivaluedMap<String, Object> headers,Entity<?> entity) {
        this.uri = uri;
        this.headers = headers;
        try {
            this.url = uri.toURL();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException();
        }
        this.entity = entity;
        if (entity != null) {
            this.headers.put("Content-type", Collections.singletonList(entity.getMediaType() + "/" + entity.getMediaType().getSubtype()));
        }
        initExcuterServicePool();
    }
    void initExcuterServicePool(){
        ExecutorService executorService = new ThreadPoolExecutor(2, 10,
                                 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                                 Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }


    @Override
    public Invocation property(String name, Object value) {
        return this;
    }

    @Override
    public Response invoke() {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(HttpMethod.POST);
            //设置报文头
//            connection.setRequestProperty("Content-Type", "application/json; utf-8");
//            connection.setRequestProperty("Accept", "application/json");
//            connection.setDoOutput(true);
            setRequestHeaders(connection);
            setRequsetBody(connection);

            // TODO Set the cookies
            int statusCode = connection.getResponseCode();
//            Response.ResponseBuilder responseBuilder = Response.status(statusCode);
//
//            responseBuilder.build();
            DefaultResponse response = new DefaultResponse();
            response.setConnection(connection);
            response.setStatus(statusCode);
            return response;
        } catch (IOException e) {
            // TODO Error handler
        }
        return null;
    }

    private void setRequsetBody(HttpURLConnection connection) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(new ObjectMapper().writeValueAsString(entity.getEntity()));
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setRequestHeaders(HttpURLConnection connection) {
        for (Map.Entry<String, List<Object>> entry : headers.entrySet()) {
            String headerName = entry.getKey();
            for (Object headerValue : entry.getValue()) {
                connection.setRequestProperty(headerName, headerValue.toString());
            }
        }
    }

    @Override
    public <T> T invoke(Class<T> responseType) {
        Response response = invoke();
        return response.readEntity(responseType);
    }

    @Override
    public <T> T invoke(GenericType<T> responseType) {
        Response response = invoke();
        return response.readEntity(responseType);
    }

    @Override
    public Future<Response> submit() {
        return executorService.submit(()->invoke(Response.class));
    }

    @Override
    public <T> Future<T> submit(Class<T> responseType) {
        return executorService.submit(()->invoke(responseType));
    }

    @Override
    public <T> Future<T> submit(GenericType<T> responseType) {
        return null;
    }

    @Override
    public <T> Future<T> submit(InvocationCallback<T> callback) {
        return null;
    }
}
