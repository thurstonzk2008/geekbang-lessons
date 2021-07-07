### week05 自定义标签helloworld实现
1. 新增自定义标签com/salesmanager/shop/tags/HelloWorldTag.java
2. 在src/main/webapp/WEB-INF/shopizer-tags.tld新增标签定义
  ```
  <tag>
        <name>helloWorldTag</name>
        <tag-class>com.salesmanager.shop.tags.HelloWorldTag</tag-class>
        <body-content>empty</body-content>
        <attribute>
            <name>name</name>
            <required>true</required>
            <rtexprvalue>true</rtexprvalue>
        </attribute>
        <attribute>
            <name>sex</name>
            <required>true</required>
            <rtexprvalue>true</rtexprvalue>
        </attribute>
        <attribute>
            <name>age</name>
            <required>true</required>
            <rtexprvalue>true</rtexprvalue>
        </attribute>
    </tag> 
    
```
        
3. 在src/main/webapp/pages/shop/templates/december/catalogLayout.jsp 使用标签
```
<sm:helloWorldTag name="test" sex="man" age="18"/>
```
各个页面左上角会有相关相关显示
