package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/15 21:17
 * 用户管理的业务接口
 */
public interface UserService {
    //查询所有用户信息
    public List<User> findAll();

    void addUser(User user);

    void deleteUser(String id);

    User findUserById(String id);

    void updateUser(User u);
}
