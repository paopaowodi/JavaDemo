package cn.ly.dao;

import cn.ly.pojo.User;

/**
 * @Author LiYun
 * @Date 2020/9/29 20:01
 * @Version 1.0
 */
public interface LoginDao {
    //根据用户名和密码获取信息
    User checkLoginDao(String uname, String pwd);
    //根据uid获取用户信息
    User checkUidDao(String uid);
}
