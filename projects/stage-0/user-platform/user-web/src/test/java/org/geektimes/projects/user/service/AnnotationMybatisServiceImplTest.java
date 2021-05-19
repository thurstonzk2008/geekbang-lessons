package org.geektimes.projects.user.service;

import org.geektimes.projects.user.cache.RedisCacheManager;
import org.geektimes.projects.user.mybatis.configuration.MySQLConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/** 
* MybatisServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>5月 18, 2021</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = RedisCacheManager.class, loader = AnnotationConfigContextLoader.class)
@ContextConfiguration (classes = MySQLConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class AnnotationMybatisServiceImplTest {

    @Autowired
    @Qualifier("annotationMybatisServiceImpl")
    private MybatisService mybatisService;

//@Before
//public void before() throws Exception {
//}
//
//@After
//public void after() throws Exception {
//}

/** 
* 
* Method: printUser() 
* 
*/ 
@Test
public void testPrintUser() throws Exception {
    mybatisService.printUser();
}


} 
