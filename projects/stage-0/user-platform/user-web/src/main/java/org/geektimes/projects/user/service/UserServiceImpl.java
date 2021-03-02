package org.geektimes.projects.user.service;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;

/**
 * UserService实现
 *
 * @author zhuhk
 * @create 2021-03-01 2:30 下午
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new DatabaseUserRepository();
    @Override
    public boolean register(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deregister(User user) {
        return userRepository.deleteById(1L);
    }

    @Override
    public boolean update(User user) {
        return userRepository.update(user);
    }

    @Override
    public User queryUserById(Long id) {
        return userRepository.getById(1L);
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return userRepository.getByNameAndPassword("name","password");
    }
}
