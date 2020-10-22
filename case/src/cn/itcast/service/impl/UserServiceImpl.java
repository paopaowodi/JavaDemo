package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/15 21:18
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {

        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User u) {
        dao.update(u);
    }

    public User login(User user) {
        return dao.findUserByNameAndPassword(user.getUsername(),user.getPassword());
    }
}
