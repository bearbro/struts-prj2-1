package cn.edu.zjut.action;

import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bro、小熊 on 2017/10/2.
 */
public class UserAction extends ActionSupport {
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

    public void validateRegister(){
        String account = this.loginUser.getAccount();
        String pwd = this.loginUser.getPassword();
        String rpwd=this.loginUser.getRepassword();
        Date brithday=this.loginUser.getBirthday();
        String email=this.loginUser.getEmail();
        if (account == null || account.equals("")) {
            this.addFieldError("loginUser.account", this.getText("reg.account.label"));
        }

        if (pwd == null || pwd.equals("")) {
            this.addFieldError("loginUser.password", this.getText("reg.password.label"));
        }
        if(rpwd==null||rpwd.equals("")){
            this.addFieldError("loginUser.repassword", this.getText("reg.repassword.label"));
        }else if (!rpwd.equals(pwd)){
            this.addFieldError("loginUser.repassword", this.getText("reg.repassword.label2"));
        }
        if (brithday==null||brithday==new Date()){
            this.addFieldError("loginUser.birthday","请输入生日");
        }else try {
            if(brithday.before((new SimpleDateFormat("yyyy-MM-dd")).parse("1001-01-01"))
                ||brithday.after((new SimpleDateFormat("yyyy-MM-dd")).parse("9999-12-31"))){
                this.addFieldError("loginUser.birthday","生日格式错误，yyyy-MM-dd");
            }
        } catch (ParseException e) {
            this.addFieldError("loginUser.birthday","生日格式错误，yyyy-MM-dd");
        }

        if(email==null||email.equals("")){
            this.addFieldError("loginUser.email","请输入邮箱！");
        }else if(isEmail(email)){
            this.addFieldError("loginUser.email","请输入正确的邮箱格式！");
        }
    }

    private boolean isEmail(String email) {
        String regex = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}" ;//正则表达式
        return match( regex ,email );
    }
    private static boolean match( String regex ,String str ){//判断str是否满足正则表达式regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher( str );
        return matcher.matches();
    }
    public String register() {
        System.out.println(loginUser.getBirthday());

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