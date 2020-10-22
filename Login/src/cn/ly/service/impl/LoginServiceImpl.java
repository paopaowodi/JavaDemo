package cn.ly.service.impl;

import cn.ly.dao.LoginDao;
import cn.ly.dao.impl.LoginDaoImpl;
import cn.ly.pojo.User;
import cn.ly.service.LoginService;

/**
 * @Author LiYun
 * @Date 2020/9/29 19:58
 * @Version 1.0
 */
public class LoginServiceImpl implements LoginService {
    //创建Dao层过度项
    LoginDao ld = new LoginDaoImpl();
    //校验用户登录信息
    @Override
    public User checkLoginService(String uname, String pwd) {

        return ld.checkLoginDao(uname,pwd);
    }
    //校验Cookie信息
    @Override
    public User checkLoginService(String uid) {
        return ld.checkUidDao(uid);
    }
}
