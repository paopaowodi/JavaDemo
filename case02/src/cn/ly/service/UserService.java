package cn.ly.service;

import cn.ly.domain.User;

import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/18 9:35
 * @Version 1.0
 */
public interface UserService {
    List<User> findAll();
    void addUser(User user);
    void delUser(String id);

}
