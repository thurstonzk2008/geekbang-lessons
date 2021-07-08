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
package com.salesmanager.shop.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * simple tag
 *
 * @Author zhk
 **/

public class HelloWorldTag extends SimpleTagSupport {
    private String name;
    private String sex;
    private int  age;

    public String getName() {
        return name;
    }


    public String getSex() {
        return sex;
    }


    public int getAge() {
        return age;
    }


    @Override
    public void doTag() throws JspException, IOException {
        this.getJspContext().getOut().write(
                "[Person Info]name: " + name + ", sex: " + sex + ", age:" + age);
    }
}
