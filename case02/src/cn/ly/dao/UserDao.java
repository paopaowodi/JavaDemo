package cn.ly.dao;

import cn.ly.domain.User;

import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/18 9:26
 * @Version 1.0
 */
public interface UserDao {
    List<User> findAll();

    void addUser(User user);
    void delUser(int id);
    User findID(int id);


}
