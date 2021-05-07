package org.geektimes.projects.user.service;

import org.geektimes.projects.user.cache.RedisCacheManager;
import org.geektimes.projects.user.domain.User;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;

/** 
* CacheServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>5月 7, 2021</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisCacheManager.class, loader = AnnotationConfigContextLoader.class)
public class CacheServiceImplTest {

    @Autowired
    private CacheService cacheService;


//@Before
//public void before() throws Exception {
//}
//
//@After
//public void after() throws Exception {
//}

/** 
* 
* Method: getUser() 
* 
*/ 
@Test
public void testGetUser() throws Exception {
    User user = cacheService.getUser();
    User user1 = cacheService.getUser();
    System.out.println(user);
    System.out.println(user1);
    assertEquals(user,user1);
}



} 
