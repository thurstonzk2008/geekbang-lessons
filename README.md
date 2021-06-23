# geekbang-lessons
## 使用Spring Boot Buildpacks support产生docker镜像
1. 本机安装docker环境
2. 使用15周springnaive的作业，进入作业目录
3. mvn spring-boot:build-image  mac环境注意给docker分配的内存要大，建议8G
4. 启动docker  docker run --rm -p 8080:8080 springnative:0.0.1-SNAPSHOT
5. 镜像已经上传到dockerhub  

## 使用dockerfile创建镜像
需要linux环境生成的可执行文件，待补充

