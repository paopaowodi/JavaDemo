package cn.ly.dao;

import cn.ly.domain.User;

import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/18 19:12
 * @Version 1.0
 */
public interface UserDao {
    void add(User user);

    List<User> findAll();

    void delUser(int id);

    User findUser(int id);

    void update(User user);
}
