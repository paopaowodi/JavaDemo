package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/15 21:19
 * 用户操作的dao
 */
public interface UserDao {

    public List<User> findAll();

    public User findUserByNameAndPassword(String username,String password);

    void add(User user);

    void delete(int parseInt);

    User findById(int parseInt);

    void update(User u);
}
