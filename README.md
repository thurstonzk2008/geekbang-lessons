# geekbang-lessons
# 新增模块 projects/stage-0/user-platform/spring-cloud-projects/spring-cloud-config-filebased-servers实现作业相关功能
# 测试方式： 
  - 启动
  - 访问 http://127.0.0.1:8888/file-config-test/default
  - 结果类似：
 ```{
name: "file-config-test",
profiles: [
"default"
],
label: null,
version: null,
state: null,
propertySources: [
{
name: "custom-source",
source: {
age: "30",
name: "zhuhk",
test: "123"
}
},
{
name: "class path resource [application.yml",
source: {
server.port: 8888
}
}
]
}  ```

# 自动更新 
- 参考了小马哥spring核心编程思想 DynamicResourceMessageSource
  
# 参考了其他同学的作业实现
