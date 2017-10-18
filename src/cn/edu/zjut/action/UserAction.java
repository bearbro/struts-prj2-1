package cn.edu.zjut.action;

import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.service.UserService;

/**
 * Created by Bro、小熊 on 2017/10/2.
 */
public class UserAction {
    private UserBean loginUser;
    private Integer count = 0;

    public UserAction() {
        System.out.print("创建了一个UserAction类对象.\n");
    }

    public Integer getCount() {
        return count;
    }

    public UserBean getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(UserBean loginUser) {
        this.loginUser = loginUser;
    }

    public String register() {
        UserService userServ = new UserService();

        if (userServ.register(loginUser)) {
            return "regsucce1ss";
        } else {
            return "regfail";
        }

    }

    public String login() {
        count++;
        UserService userServ = new UserService();
        if (userServ.login(loginUser)) {
            return "logsuccess";
        } else {
            return "logfail";
        }
    }
}
