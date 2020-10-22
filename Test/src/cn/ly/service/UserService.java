package cn.ly.service;

import cn.ly.domain.User;

import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/18 19:12
 * @Version 1.0
 */
public interface UserService {
    void add(User user);

    List<User> findAll();

    void delUser(String id);
    User findUser(String id);

    void update(User user);
}
