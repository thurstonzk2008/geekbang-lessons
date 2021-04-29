# geekbang-lessons
## 实验1 
1. 使用springboot集成spring security，参考my-oauth2模块
2. 在config模块下定义三个config类，OauthConfig，SecurityConfig，SecurityConfig1，打包报错@Order on WebSecurityConfigurers must be unique. Order of 100 was already used on org.geektime.oauth2.Oauth2Application$$EnhancerBySpringCGLIB$$161893a7@189b5fb1, so it cannot be used on org.geektime.oauth2.config.OauthConfig$$EnhancerBySpringCGLIB$$62aca5f@783ec989 too.
3. 使用order注解定义优先级
4. 引入WebSecurityConfigurationOrderPostProcessor进行排序，进行测试
