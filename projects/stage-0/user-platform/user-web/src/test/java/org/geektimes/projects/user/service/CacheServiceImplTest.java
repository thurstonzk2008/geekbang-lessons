package org.geektimes.projects.user.service;

import org.geektimes.projects.user.domain.User;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;

/** 
* CacheServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>5月 7, 2021</pre> 
* @version 1.0 
*/ 
public class CacheServiceImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getUser() 
* 
*/ 
@Test
public void testGetUser() throws Exception {
//TODO: Test goes here...
    CacheService cacheService = new CacheServiceImpl();
    User user = cacheService.getUser();
    User user1 = cacheService.getUser();
    System.out.println(user);
    System.out.println(user1);
    assertEquals(user,user1);
}



} 
