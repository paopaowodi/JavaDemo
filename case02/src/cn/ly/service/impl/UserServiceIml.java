package cn.ly.service.impl;

import cn.ly.dao.UserDao;
import cn.ly.dao.impl.UserDaoImpl;
import cn.ly.domain.User;
import cn.ly.service.UserService;

import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/18 9:36
 * @Version 1.0
 */
public class UserServiceIml implements UserService {

    UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void delUser(String id) {
        dao.delUser(Integer.parseInt(id));
    }


}
