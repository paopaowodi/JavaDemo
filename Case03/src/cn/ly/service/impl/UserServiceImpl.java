package cn.ly.service.impl;

import cn.ly.dao.UserDao;
import cn.ly.dao.impl.UserDaoImpl;
import cn.ly.domain.User;
import cn.ly.service.UserService;

import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/18 18:15
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
