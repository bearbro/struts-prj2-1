package cn.edu.zjut.action;

import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bro、小熊 on 2017/10/2.
 */
public class UserAction extends ActionSupport
        implements RequestAware,SessionAware,ApplicationAware{
    private UserBean loginUser;
    private Integer count = Integer.valueOf(0);
    private Map request;
    private Map session;
    private Map application;

    public void setRequest(Map<String,Object>request) {
        this.request=request;
    }

    public void setSession(Map<String,Object> session) {
        this.session = session;
    }

    public void setApplication(Map<String,Object> application) {
        this.application = application;
    }

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

    //    public void validate() {
//        String account = this.loginUser.getAccount();
//        String pwd = this.loginUser.getPassword();
//        if (account == null || account.equals("")) {
//            this.addFieldError("loginUser.account", this.getText("login.account.label"));
//        }
//
//        if (pwd == null || pwd.equals("")) {
//            this.addFieldError("loginUser.password", this.getText("login.password.label"));
//        }
//
//    }
    public void validateLogin() {
        String account = this.loginUser.getAccount();
        String pwd = this.loginUser.getPassword();
        if (account == null || account.equals("")) {
            this.addFieldError("loginUser.account", this.getText("login.account.label"));
        }

        if (pwd == null || pwd.equals("")) {
            this.addFieldError("loginUser.password", this.getText("login.password.label"));
        }

    }

    public void validateRegister() {
        String account = this.loginUser.getAccount();
        String pwd = this.loginUser.getPassword();
        String rpwd = this.loginUser.getRepassword();
        Date brithday = this.loginUser.getBirthday();
        String email = this.loginUser.getEmail();
        if (account == null || account.equals("")) {
            this.addFieldError("loginUser.account", this.getText("reg.account.label"));
        }

        if (pwd == null || pwd.equals("")) {
            this.addFieldError("loginUser.password", this.getText("reg.password.label"));
        }
        if (rpwd == null || rpwd.equals("")) {
            this.addFieldError("loginUser.repassword", this.getText("reg.repassword.label"));
        } else if (!rpwd.equals(pwd)) {
            this.addFieldError("loginUser.repassword", this.getText("reg.repassword.label2"));
        }
        if (brithday == null || brithday == new Date()) {
            this.addFieldError("loginUser.birthday", "请输入生日");
        } else try {
            if (brithday.before((new SimpleDateFormat("yyyy-MM-dd")).parse("1001-01-01"))
                    || brithday.after((new SimpleDateFormat("yyyy-MM-dd")).parse("9999-12-31"))) {
                this.addFieldError("loginUser.birthday", this.getText("reg.birthday.label2"));
            }
        } catch (ParseException e) {
            this.addFieldError("loginUser.birthday", this.getText("reg.birthday.label2"));
        }

        if (email == null || email.equals("")) {
            this.addFieldError("loginUser.email", this.getText("reg.email.label"));
        } else if (isEmail(email)) {
            this.addFieldError("loginUser.email", this.getText("reg.email.label2"));
        }
    }

    private boolean isEmail(String email) {
        String regex = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";//正则表达式
        return match(regex, email);
    }

    private static boolean match(String regex, String str) {//判断str是否满足正则表达式regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public String register() {
        System.out.println(loginUser.getBirthday());

        UserService userServ = new UserService();
        return userServ.register(this.loginUser) ? "regsuccess" : "regfail";
    }

    public String login() {
        Integer counter = (Integer) application.get("counter");
        if (counter == null) {
            counter = 1;
        } else {
            counter++;
        }
        application.put("counter", counter);
        this.count++;
        UserService userServ = new UserService();
        if (userServ.login(this.loginUser)) {
            session.put("user", loginUser.getAccount());
            request.put("tip", "您已登录成功");
            this.addActionMessage(this.getText("login.success"));
            return "logsuccess";
        } else {
            this.addActionError(this.getText("login.fail"));
            return "logfail";
        }
    }
}