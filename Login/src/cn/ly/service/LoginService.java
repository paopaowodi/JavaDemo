package cn.ly.service;

import cn.ly.pojo.User;

/**
 * @Author LiYun
 * @Date 2020/9/29 19:54
 * @Version 1.0
 */
public interface LoginService {
    //校验用户登录信息
    User checkLoginService(String uname, String pwd);
    //校验用户Cookie信息
    User checkLoginService(String uid);
}
