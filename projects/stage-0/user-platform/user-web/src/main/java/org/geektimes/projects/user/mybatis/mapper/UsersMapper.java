package org.geektimes.projects.user.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.geektimes.projects.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-05-15 6:10 下午
 * @Version 1.0
 **/
//@Repository("UsersMapper")
//@Mapper

    public interface UsersMapper {

        List<User> getAll();

}
