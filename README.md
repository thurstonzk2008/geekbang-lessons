因为我的操作系统是macOS，所以下面的步骤在mac上安装
## 安装GraalVM
1. 下载macOS上的GraalVM安装包
https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-21.1.0 
选择mac版本，我选择的是jdk11的的版本
下载完成后 本地会有
graalvm-ce-java11-darwin-amd64-21.1.0.tar.gz
2. 安装
参考 https://www.graalvm.org/docs/getting-started/macos/
3. 安装 native-imag
在GraalVM虚拟机目录/bin目录下，
./gu install native-image
注意，可能需要fq
4. 使用https://start.springboot.io/ 生成spring-native源代码
5. mvn -Pnative -DskipTests packag
类似如下内容
```
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------< com.zhk:springnative >------------------------
[INFO] Building springnative 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:3.2.0:resources (default-resources) @ springnative ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ springnative ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:3.2.0:testResources (default-testResources) @ springnative ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] skip non existing resourceDirectory /Users/zhk/workspaces/geekbang-lessons/springnative/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ springnative ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- spring-aot-maven-plugin:0.10.0:test-generate (test-generate) @ springnative ---
[INFO] Spring Native operating mode: native
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.data.jpa.repository.support.EntityManagerBeanDefinitionRegistrarPostProcessor it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.security.config.annotation.web.configuration.AutowiredWebSecurityConfigurersIgnoreParents it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: io.netty.channel.socket.nio.NioSocketChannel it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.messaging.handler.annotation.MessageMapping it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.transaction.annotation.Transactional it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: javax.transaction.Transactional it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.transaction.annotation.Propagation it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.web.reactive.socket.server.upgrade.TomcatRequestUpgradeStrategy it will be skipped
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 37 source files to /Users/zhk/workspaces/geekbang-lessons/springnative/target/test-classes
[INFO] /Users/zhk/workspaces/geekbang-lessons/springnative/target/generated-test-sources/spring-aot/src/test/java/org/springframework/aot/StaticSpringFactories.java: 某些输入文件使用或覆盖了已过时的 API。
[INFO] /Users/zhk/workspaces/geekbang-lessons/springnative/target/generated-test-sources/spring-aot/src/test/java/org/springframework/aot/StaticSpringFactories.java: 有关详细信息, 请使用 -Xlint:deprecation 重新编译。
[INFO] /Users/zhk/workspaces/geekbang-lessons/springnative/target/generated-test-sources/spring-aot/src/test/java/org/springframework/aot/StaticSpringFactories.java: /Users/zhk/workspaces/geekbang-lessons/springnative/target/generated-test-sources/spring-aot/src/test/java/org/springframework/aot/StaticSpringFactories.java使用了未经检查或不安全的操作。
[INFO] /Users/zhk/workspaces/geekbang-lessons/springnative/target/generated-test-sources/spring-aot/src/test/java/org/springframework/aot/StaticSpringFactories.java: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] Copying 5 resources
[INFO]
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ springnative ---
[INFO] Tests are skipped.
[INFO]
[INFO] --- native-maven-plugin:0.9.0:test (test-native) @ springnative ---
[INFO] Tests are skipped.
[INFO]
[INFO] --- spring-aot-maven-plugin:0.10.0:generate (generate) @ springnative ---
[INFO] Spring Native operating mode: native
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.data.jpa.repository.support.EntityManagerBeanDefinitionRegistrarPostProcessor it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.security.config.annotation.web.configuration.AutowiredWebSecurityConfigurersIgnoreParents it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: io.netty.channel.socket.nio.NioSocketChannel it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.boot.test.autoconfigure.json.JsonTest it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.boot.test.autoconfigure.json.JsonTestContextBootstrapper it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.boot.test.autoconfigure.json.JsonTypeExcludeFilter it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTypeExcludeFilter it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: com.zhk.springnative.SpringnativeApplicationTests it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.messaging.handler.annotation.MessageMapping it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.transaction.annotation.Transactional it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: javax.transaction.Transactional it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.transaction.annotation.Propagation it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.data.jpa.repository.support.EntityManagerBeanDefinitionRegistrarPostProcessor it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.security.config.annotation.web.configuration.AutowiredWebSecurityConfigurersIgnoreParents it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: io.netty.channel.socket.nio.NioSocketChannel it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.messaging.handler.annotation.MessageMapping it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.transaction.annotation.Transactional it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: javax.transaction.Transactional it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.transaction.annotation.Propagation it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.web.reactive.socket.server.upgrade.TomcatRequestUpgradeStrategy it will be skipped
[WARNING] Failed verification check: this type was requested to be added to configuration but is not resolvable: org.springframework.web.reactive.socket.server.upgrade.TomcatRequestUpgradeStrategy it will be skipped
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 22 source files to /Users/zhk/workspaces/geekbang-lessons/springnative/target/classes
[INFO] /Users/zhk/workspaces/geekbang-lessons/springnative/target/generated-sources/spring-aot/src/main/java/org/springframework/aot/StaticSpringFactories.java: 某些输入文件使用或覆盖了已过时的 API。
[INFO] /Users/zhk/workspaces/geekbang-lessons/springnative/target/generated-sources/spring-aot/src/main/java/org/springframework/aot/StaticSpringFactories.java: 有关详细信息, 请使用 -Xlint:deprecation 重新编译。
[INFO] /Users/zhk/workspaces/geekbang-lessons/springnative/target/generated-sources/spring-aot/src/main/java/org/springframework/aot/StaticSpringFactories.java: /Users/zhk/workspaces/geekbang-lessons/springnative/target/generated-sources/spring-aot/src/main/java/org/springframework/aot/StaticSpringFactories.java使用了未经检查或不安全的操作。
[INFO] /Users/zhk/workspaces/geekbang-lessons/springnative/target/generated-sources/spring-aot/src/main/java/org/springframework/aot/StaticSpringFactories.java: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] Copying 5 resources
[INFO]
[INFO] --- maven-jar-plugin:3.2.0:jar (default-jar) @ springnative ---
[INFO] Building jar: /Users/zhk/workspaces/geekbang-lessons/springnative/target/springnative-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:2.5.1:repackage (repackage) @ springnative ---
[INFO] Attaching repackaged archive /Users/zhk/workspaces/geekbang-lessons/springnative/target/springnative-0.0.1-SNAPSHOT-exec.jar with classifier exec
[INFO]
[INFO] --- native-maven-plugin:0.9.0:build (build-native) @ springnative ---
[INFO] ImageClasspath Entry: org.springframework.boot:spring-boot-starter-web:jar:2.5.1:compile (file:///Users/zhk/.m2/repository/org/springframework/boot/spring-boot-starter-web/2.5.1/spring-boot-starter-web-2.5.1.jar)
[INFO] ImageClasspath Entry: org.springframework.boot:spring-boot-starter:jar:2.5.1:compile (file:///Users/zhk/.m2/repository/org/springframework/boot/spring-boot-starter/2.5.1/spring-boot-starter-2.5.1.jar)
[INFO] ImageClasspath Entry: org.springframework.boot:spring-boot:jar:2.5.1:compile (file:///Users/zhk/.m2/repository/org/springframework/boot/spring-boot/2.5.1/spring-boot-2.5.1.jar)
[INFO] ImageClasspath Entry: org.springframework.boot:spring-boot-autoconfigure:jar:2.5.1:compile (file:///Users/zhk/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/2.5.1/spring-boot-autoconfigure-2.5.1.jar)
[INFO] ImageClasspath Entry: org.springframework.boot:spring-boot-starter-logging:jar:2.5.1:compile (file:///Users/zhk/.m2/repository/org/springframework/boot/spring-boot-starter-logging/2.5.1/spring-boot-starter-logging-2.5.1.jar)
[INFO] ImageClasspath Entry: ch.qos.logback:logback-classic:jar:1.2.3:compile (file:///Users/zhk/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar)
[INFO] ImageClasspath Entry: ch.qos.logback:logback-core:jar:1.2.3:compile (file:///Users/zhk/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar)
[INFO] ImageClasspath Entry: org.apache.logging.log4j:log4j-to-slf4j:jar:2.14.1:compile (file:///Users/zhk/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.14.1/log4j-to-slf4j-2.14.1.jar)
[INFO] ImageClasspath Entry: org.apache.logging.log4j:log4j-api:jar:2.14.1:compile (file:///Users/zhk/.m2/repository/org/apache/logging/log4j/log4j-api/2.14.1/log4j-api-2.14.1.jar)
[INFO] ImageClasspath Entry: org.slf4j:jul-to-slf4j:jar:1.7.30:compile (file:///Users/zhk/.m2/repository/org/slf4j/jul-to-slf4j/1.7.30/jul-to-slf4j-1.7.30.jar)
[INFO] ImageClasspath Entry: jakarta.annotation:jakarta.annotation-api:jar:1.3.5:compile (file:///Users/zhk/.m2/repository/jakarta/annotation/jakarta.annotation-api/1.3.5/jakarta.annotation-api-1.3.5.jar)
[INFO] ImageClasspath Entry: org.yaml:snakeyaml:jar:1.28:compile (file:///Users/zhk/.m2/repository/org/yaml/snakeyaml/1.28/snakeyaml-1.28.jar)
[INFO] ImageClasspath Entry: org.springframework.boot:spring-boot-starter-json:jar:2.5.1:compile (file:///Users/zhk/.m2/repository/org/springframework/boot/spring-boot-starter-json/2.5.1/spring-boot-starter-json-2.5.1.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.core:jackson-databind:jar:2.12.3:compile (file:///Users/zhk/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.12.3/jackson-databind-2.12.3.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.core:jackson-annotations:jar:2.12.3:compile (file:///Users/zhk/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.12.3/jackson-annotations-2.12.3.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.core:jackson-core:jar:2.12.3:compile (file:///Users/zhk/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.12.3/jackson-core-2.12.3.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.12.3:compile (file:///Users/zhk/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.12.3/jackson-datatype-jdk8-2.12.3.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.12.3:compile (file:///Users/zhk/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.12.3/jackson-datatype-jsr310-2.12.3.jar)
[INFO] ImageClasspath Entry: com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.12.3:compile (file:///Users/zhk/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.12.3/jackson-module-parameter-names-2.12.3.jar)
[INFO] ImageClasspath Entry: org.springframework.boot:spring-boot-starter-tomcat:jar:2.5.1:compile (file:///Users/zhk/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/2.5.1/spring-boot-starter-tomcat-2.5.1.jar)
[INFO] ImageClasspath Entry: org.apache.tomcat.embed:tomcat-embed-core:jar:9.0.46:compile (file:///Users/zhk/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/9.0.46/tomcat-embed-core-9.0.46.jar)
[INFO] ImageClasspath Entry: org.apache.tomcat.embed:tomcat-embed-el:jar:9.0.46:compile (file:///Users/zhk/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/9.0.46/tomcat-embed-el-9.0.46.jar)
[INFO] ImageClasspath Entry: org.apache.tomcat.embed:tomcat-embed-websocket:jar:9.0.46:compile (file:///Users/zhk/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/9.0.46/tomcat-embed-websocket-9.0.46.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-web:jar:5.3.8:compile (file:///Users/zhk/.m2/repository/org/springframework/spring-web/5.3.8/spring-web-5.3.8.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-beans:jar:5.3.8:compile (file:///Users/zhk/.m2/repository/org/springframework/spring-beans/5.3.8/spring-beans-5.3.8.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-webmvc:jar:5.3.8:compile (file:///Users/zhk/.m2/repository/org/springframework/spring-webmvc/5.3.8/spring-webmvc-5.3.8.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-aop:jar:5.3.8:compile (file:///Users/zhk/.m2/repository/org/springframework/spring-aop/5.3.8/spring-aop-5.3.8.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-context:jar:5.3.8:compile (file:///Users/zhk/.m2/repository/org/springframework/spring-context/5.3.8/spring-context-5.3.8.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-expression:jar:5.3.8:compile (file:///Users/zhk/.m2/repository/org/springframework/spring-expression/5.3.8/spring-expression-5.3.8.jar)
[INFO] ImageClasspath Entry: org.springframework.experimental:spring-native:jar:0.10.0:compile (file:///Users/zhk/.m2/repository/org/springframework/experimental/spring-native/0.10.0/spring-native-0.10.0.jar)
[INFO] ImageClasspath Entry: org.slf4j:slf4j-api:jar:1.7.30:compile (file:///Users/zhk/.m2/repository/org/slf4j/slf4j-api/1.7.30/slf4j-api-1.7.30.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-core:jar:5.3.8:compile (file:///Users/zhk/.m2/repository/org/springframework/spring-core/5.3.8/spring-core-5.3.8.jar)
[INFO] ImageClasspath Entry: org.springframework:spring-jcl:jar:5.3.8:compile (file:///Users/zhk/.m2/repository/org/springframework/spring-jcl/5.3.8/spring-jcl-5.3.8.jar)
[INFO] ImageClasspath Entry: com.zhk:springnative:jar:0.0.1-SNAPSHOT (file:///Users/zhk/workspaces/geekbang-lessons/springnative/target/springnative-0.0.1-SNAPSHOT.jar)
[WARNING] jar:file:///Users/zhk/workspaces/geekbang-lessons/springnative/target/springnative-0.0.1-SNAPSHOT.jar!/META-INF/native-image/org.springframework.aot/spring-aot/native-image.properties does not match recommended META-INF/native-image/${groupId}/${artifactId}/native-image.properties layout.
[INFO] Executing: /Library/Java/JavaVirtualMachines/graalvm-ce-java11-21.1.0/Contents/Home/bin/native-image -cp /Users/zhk/.m2/repository/org/springframework/boot/spring-boot-starter-web/2.5.1/spring-boot-starter-web-2.5.1.jar:/Users/zhk/.m2/repository/org/springframework/boot/spring-boot-starter/2.5.1/spring-boot-starter-2.5.1.jar:/Users/zhk/.m2/repository/org/springframework/boot/spring-boot/2.5.1/spring-boot-2.5.1.jar:/Users/zhk/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/2.5.1/spring-boot-autoconfigure-2.5.1.jar:/Users/zhk/.m2/repository/org/springframework/boot/spring-boot-starter-logging/2.5.1/spring-boot-starter-logging-2.5.1.jar:/Users/zhk/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar:/Users/zhk/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar:/Users/zhk/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.14.1/log4j-to-slf4j-2.14.1.jar:/Users/zhk/.m2/repository/org/apache/logging/log4j/log4j-api/2.14.1/log4j-api-2.14.1.jar:/Users/zhk/.m2/repository/org/slf4j/jul-to-slf4j/1.7.30/jul-to-slf4j-1.7.30.jar:/Users/zhk/.m2/repository/jakarta/annotation/jakarta.annotation-api/1.3.5/jakarta.annotation-api-1.3.5.jar:/Users/zhk/.m2/repository/org/yaml/snakeyaml/1.28/snakeyaml-1.28.jar:/Users/zhk/.m2/repository/org/springframework/boot/spring-boot-starter-json/2.5.1/spring-boot-starter-json-2.5.1.jar:/Users/zhk/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.12.3/jackson-databind-2.12.3.jar:/Users/zhk/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.12.3/jackson-annotations-2.12.3.jar:/Users/zhk/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.12.3/jackson-core-2.12.3.jar:/Users/zhk/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.12.3/jackson-datatype-jdk8-2.12.3.jar:/Users/zhk/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.12.3/jackson-datatype-jsr310-2.12.3.jar:/Users/zhk/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.12.3/jackson-module-parameter-names-2.12.3.jar:/Users/zhk/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/2.5.1/spring-boot-starter-tomcat-2.5.1.jar:/Users/zhk/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/9.0.46/tomcat-embed-core-9.0.46.jar:/Users/zhk/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/9.0.46/tomcat-embed-el-9.0.46.jar:/Users/zhk/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/9.0.46/tomcat-embed-websocket-9.0.46.jar:/Users/zhk/.m2/repository/org/springframework/spring-web/5.3.8/spring-web-5.3.8.jar:/Users/zhk/.m2/repository/org/springframework/spring-beans/5.3.8/spring-beans-5.3.8.jar:/Users/zhk/.m2/repository/org/springframework/spring-webmvc/5.3.8/spring-webmvc-5.3.8.jar:/Users/zhk/.m2/repository/org/springframework/spring-aop/5.3.8/spring-aop-5.3.8.jar:/Users/zhk/.m2/repository/org/springframework/spring-context/5.3.8/spring-context-5.3.8.jar:/Users/zhk/.m2/repository/org/springframework/spring-expression/5.3.8/spring-expression-5.3.8.jar:/Users/zhk/.m2/repository/org/springframework/experimental/spring-native/0.10.0/spring-native-0.10.0.jar:/Users/zhk/.m2/repository/org/slf4j/slf4j-api/1.7.30/slf4j-api-1.7.30.jar:/Users/zhk/.m2/repository/org/springframework/spring-core/5.3.8/spring-core-5.3.8.jar:/Users/zhk/.m2/repository/org/springframework/spring-jcl/5.3.8/spring-jcl-5.3.8.jar:/Users/zhk/workspaces/geekbang-lessons/springnative/target/springnative-0.0.1-SNAPSHOT.jar -H:Name=springnative
[springnative:72393]    classlist:   2,289.04 ms,  0.96 GB
[springnative:72393]        (cap):   5,222.38 ms,  0.96 GB
[springnative:72393]        setup:   9,442.47 ms,  0.96 GB
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/serializer/RedisSerializer.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/infinispan/manager/EmbeddedCacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.sql.init.R2dbcInitializationConfiguration. Reason: java.lang.NoClassDefFoundError: io/r2dbc/spi/ConnectionFactory.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration. Reason: java.lang.NoClassDefFoundError: com/hazelcast/core/HazelcastInstance.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: javax/cache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/validation/ValidatorFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: net/sf/ehcache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/json/bind/Jsonb.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/cache/caffeine/CaffeineCacheManager.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/couchbase/CouchbaseClientFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration. Reason: java.lang.NoClassDefFoundError: com/google/gson/GsonBuilder.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/connection/RedisConnectionFactory.
WARNING: Could not register reflection metadata for org.springframework.web.multipart.commons.CommonsMultipartResolver. Reason: java.lang.NoClassDefFoundError: org/apache/commons/fileupload/FileItemFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/serializer/RedisSerializer.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/infinispan/manager/EmbeddedCacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.sql.init.R2dbcInitializationConfiguration. Reason: java.lang.NoClassDefFoundError: io/r2dbc/spi/ConnectionFactory.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration. Reason: java.lang.NoClassDefFoundError: com/hazelcast/core/HazelcastInstance.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: javax/cache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/validation/ValidatorFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: net/sf/ehcache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/json/bind/Jsonb.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/cache/caffeine/CaffeineCacheManager.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/couchbase/CouchbaseClientFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration. Reason: java.lang.NoClassDefFoundError: com/google/gson/GsonBuilder.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/connection/RedisConnectionFactory.
WARNING: Could not register reflection metadata for org.springframework.web.multipart.commons.CommonsMultipartResolver. Reason: java.lang.NoClassDefFoundError: org/apache/commons/fileupload/FileItemFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/infinispan/manager/EmbeddedCacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/json/bind/Jsonb.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration. Reason: java.lang.NoClassDefFoundError: com/google/gson/GsonBuilder.
WARNING: Could not register reflection metadata for org.springframework.web.multipart.commons.CommonsMultipartResolver. Reason: java.lang.NoClassDefFoundError: org/apache/commons/fileupload/FileItemFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/serializer/RedisSerializer.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.sql.init.R2dbcInitializationConfiguration. Reason: java.lang.NoClassDefFoundError: io/r2dbc/spi/ConnectionFactory.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration. Reason: java.lang.NoClassDefFoundError: com/hazelcast/core/HazelcastInstance.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: javax/cache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/validation/ValidatorFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: net/sf/ehcache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/cache/caffeine/CaffeineCacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/couchbase/CouchbaseClientFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/connection/RedisConnectionFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/infinispan/manager/EmbeddedCacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/json/bind/Jsonb.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration. Reason: java.lang.NoClassDefFoundError: com/google/gson/GsonBuilder.
WARNING: Could not register reflection metadata for org.springframework.web.multipart.commons.CommonsMultipartResolver. Reason: java.lang.NoClassDefFoundError: org/apache/commons/fileupload/FileItemFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/serializer/RedisSerializer.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.sql.init.R2dbcInitializationConfiguration. Reason: java.lang.NoClassDefFoundError: io/r2dbc/spi/ConnectionFactory.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration. Reason: java.lang.NoClassDefFoundError: com/hazelcast/core/HazelcastInstance.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: javax/cache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/validation/ValidatorFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: net/sf/ehcache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/cache/caffeine/CaffeineCacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/couchbase/CouchbaseClientFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/connection/RedisConnectionFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/infinispan/manager/EmbeddedCacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/json/bind/Jsonb.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration. Reason: java.lang.NoClassDefFoundError: com/google/gson/GsonBuilder.
WARNING: Could not register reflection metadata for org.springframework.web.multipart.commons.CommonsMultipartResolver. Reason: java.lang.NoClassDefFoundError: org/apache/commons/fileupload/FileItemFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/serializer/RedisSerializer.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.sql.init.R2dbcInitializationConfiguration. Reason: java.lang.NoClassDefFoundError: io/r2dbc/spi/ConnectionFactory.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration. Reason: java.lang.NoClassDefFoundError: com/hazelcast/core/HazelcastInstance.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: javax/cache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/validation/ValidatorFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: net/sf/ehcache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/cache/caffeine/CaffeineCacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/couchbase/CouchbaseClientFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/connection/RedisConnectionFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/infinispan/manager/EmbeddedCacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/json/bind/Jsonb.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration. Reason: java.lang.NoClassDefFoundError: com/google/gson/GsonBuilder.
WARNING: Could not register reflection metadata for org.springframework.web.multipart.commons.CommonsMultipartResolver. Reason: java.lang.NoClassDefFoundError: org/apache/commons/fileupload/FileItemFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/serializer/RedisSerializer.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.sql.init.R2dbcInitializationConfiguration. Reason: java.lang.NoClassDefFoundError: io/r2dbc/spi/ConnectionFactory.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration. Reason: java.lang.NoClassDefFoundError: com/hazelcast/core/HazelcastInstance.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: javax/cache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/validation/ValidatorFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: net/sf/ehcache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/cache/caffeine/CaffeineCacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/couchbase/CouchbaseClientFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/connection/RedisConnectionFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/infinispan/manager/EmbeddedCacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/json/bind/Jsonb.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration. Reason: java.lang.NoClassDefFoundError: com/google/gson/GsonBuilder.
WARNING: Could not register reflection metadata for org.springframework.web.multipart.commons.CommonsMultipartResolver. Reason: java.lang.NoClassDefFoundError: org/apache/commons/fileupload/FileItemFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/serializer/RedisSerializer.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.sql.init.R2dbcInitializationConfiguration. Reason: java.lang.NoClassDefFoundError: io/r2dbc/spi/ConnectionFactory.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator. Reason: java.lang.NoClassDefFoundError: org/aspectj/util/PartialOrder$PartialComparable.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration. Reason: java.lang.NoClassDefFoundError: com/hazelcast/core/HazelcastInstance.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: javax/cache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration. Reason: java.lang.NoClassDefFoundError: javax/validation/ValidatorFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration. Reason: java.lang.NoClassDefFoundError: net/sf/ehcache/CacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/cache/caffeine/CaffeineCacheManager.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/couchbase/CouchbaseClientFactory.
WARNING: Could not register reflection metadata for org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration. Reason: java.lang.NoClassDefFoundError: org/springframework/data/redis/connection/RedisConnectionFactory.
[springnative:72393]     (clinit):   1,148.19 ms,  5.33 GB
[springnative:72393]   (typeflow):  27,281.11 ms,  5.33 GB
[springnative:72393]    (objects):  39,402.18 ms,  5.33 GB
[springnative:72393]   (features):   3,659.08 ms,  5.33 GB
[springnative:72393]     analysis:  73,675.28 ms,  5.33 GB
[springnative:72393]     universe:   2,252.49 ms,  5.29 GB
[springnative:72393]      (parse):   5,574.61 ms,  5.29 GB
[springnative:72393]     (inline):  11,666.35 ms,  6.10 GB
[springnative:72393]    (compile):  46,561.87 ms,  6.52 GB
[springnative:72393]      compile:  67,848.15 ms,  6.52 GB
[springnative:72393]        image:   6,924.86 ms,  6.45 GB
[springnative:72393]        write:   1,684.05 ms,  6.45 GB
# Printing build artifacts to: springnative.build_artifacts.txt
[springnative:72393]      [total]: 164,965.46 ms,  6.45 GB
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  02:58 min
[INFO] Finished at: 2021-06-15T19:45:13+08:00
[INFO] ------------------------------------------------------------------------
```
6. 在target目录下运行native程序
```
2021-06-15 19:47:17.766  INFO 72802 --- [           main] o.s.nativex.NativeListener               : This application is bootstrapped with code generated with Spring AOT

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.1)

2021-06-15 19:47:17.770  INFO 72802 --- [           main] c.z.s.SpringnativeApplication            : Starting SpringnativeApplication v0.0.1-SNAPSHOT using Java 11.0.11 on zhkdeMacBook-Pro.local with PID 72802 (/Users/zhk/workspaces/geekbang-lessons/springnative/target/springnative started by zhk in /Users/zhk/workspaces/geekbang-lessons/springnative/target)
2021-06-15 19:47:17.770  INFO 72802 --- [           main] c.z.s.SpringnativeApplication            : No active profile set, falling back to default profiles: default
2021-06-15 19:47:17.813  INFO 72802 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
Jun 15, 2021 7:47:17 PM org.apache.coyote.AbstractProtocol init
INFO: Initializing ProtocolHandler ["http-nio-8080"]
Jun 15, 2021 7:47:17 PM org.apache.catalina.core.StandardService startInternal
INFO: Starting service [Tomcat]
Jun 15, 2021 7:47:17 PM org.apache.catalina.core.StandardEngine startInternal
INFO: Starting Servlet engine: [Apache Tomcat/9.0.46]
Jun 15, 2021 7:47:17 PM org.apache.catalina.core.ApplicationContext log
INFO: Initializing Spring embedded WebApplicationContext
2021-06-15 19:47:17.816  INFO 72802 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 45 ms
Jun 15, 2021 7:47:17 PM org.apache.coyote.AbstractProtocol start
INFO: Starting ProtocolHandler ["http-nio-8080"]
2021-06-15 19:47:17.836  INFO 72802 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-06-15 19:47:17.837  INFO 72802 --- [           main] c.z.s.SpringnativeApplication            : Started SpringnativeApplication in 0.31 seconds (JVM running for 0.313)
Jun 15, 2021 7:47:43 PM org.apache.catalina.core.ApplicationContext log
INFO: Initializing Spring DispatcherServlet 'dispatcherServlet'
2021-06-15 19:47:43.768  INFO 72802 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2021-06-15 19:47:43.769  INFO 72802 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
```

