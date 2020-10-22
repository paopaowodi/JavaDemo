package cn.ly.service;

import cn.ly.domain.User;

import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/18 18:14
 * @Version 1.0
 */
public interface UserService {
    List<User> findAll();
}
