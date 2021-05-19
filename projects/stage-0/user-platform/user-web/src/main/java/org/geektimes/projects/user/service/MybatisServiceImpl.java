package org.geektimes.projects.user.service;

import org.geektimes.projects.user.mybatis.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-05-18 6:55 上午
 * @Version 1.0
 **/
@Service
public class MybatisServiceImpl implements MybatisService{

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public void printUser() {
        System.out.println(usersMapper.getAll());
    }
}
