package cn.ly.dao;

import cn.ly.domain.User;

import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/18 18:15
 * @Version 1.0
 */
public interface UserDao {
    List<User> findAll();
}
