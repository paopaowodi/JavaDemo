package cn.ly.service.impl;

import cn.ly.dao.UserDao;
import cn.ly.dao.impl.UserDaoImpl;
import cn.ly.domain.User;
import cn.ly.service.UserService;

import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/18 19:13
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoImpl();
    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public void delUser(String id) {
        dao.delUser(Integer.parseInt(id));
    }

    public User findUser(String id) {
        return dao.findUser(Integer.parseInt(id));
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }
}
