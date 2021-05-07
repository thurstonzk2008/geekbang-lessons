# geekbang-lessons
## 打通spring cache 和@cacheable
1. org.geektimes.projects.user.cache.RedisCacheManager 标识@EnableCaching，@Configuration，@Bean标识 RedisCacheManager 
   todo ：jedis等配置的配置化修改
2. 新增 org.geektimes.projects.user.service.CacheServiceImpl#getUse 标识@Cachaeable
3. 新增测试 org.geektimes.projects.user.service.CacheServiceImplTest  如果是直接获取，打印get user from real，从缓存中获取没有打印信息 
