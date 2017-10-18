package cn.edu.zjut.action;

import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Bro、小熊 on 2017/10/2.
 */public class UserAction extends ActionSupport {
    private UserBean loginUser;
    private Integer count = Integer.valueOf(0);

    public UserAction() {
        System.out.print("创建了一个UserAction类对象.\n");
    }

    public Integer getCount() {
        return this.count;
    }

    public UserBean getLoginUser() {
        return this.loginUser;
    }

    public void setLoginUser(UserBean loginUser) {
        this.loginUser = loginUser;
    }

    public void validate() {
        String account = this.loginUser.getAccount();
        String pwd = this.loginUser.getPassword();
        if (account == null || account.equals("")) {
            this.addFieldError("loginUser.account", this.getText("login.account.label"));
        }

        if (pwd == null || pwd.equals("")) {
            this.addFieldError("loginUser.password", this.getText("login.password.label"));
        }

    }

    public String register() {
        UserService userServ = new UserService();
        return userServ.register(this.loginUser) ? "regsuccess" : "regfail";
    }

    public String login() {
        Integer var1 = this.count;
        Integer var2 = this.count = this.count.intValue() + 1;
        UserService userServ = new UserService();
        if (userServ.login(this.loginUser)) {
            this.addActionMessage(this.getText("login.success"));
            return "logsuccess";
        } else {
            this.addActionError(this.getText("login.fail"));
            return "logfail";
        }
    }
}