package cn.edu.zjut.service;

import cn.edu.zjut.bean.UserBean;

/**
 * Created by Bro、小熊 on 2017/10/2.
 */
public class UserService {
    public boolean login(UserBean loginUser) {
        if (loginUser.getAccount().equals(loginUser.getPassword())) {
            return true;
        }
        return false;
    }

    public boolean register(UserBean regUser) {
        if ((!regUser.getAccount().equals(""))
                && regUser.getAccount().equals(regUser.getPassword())
                && regUser.getPassword().equals(regUser.getRepassword())) {
            return true;
        }
        return false;
    }
}
