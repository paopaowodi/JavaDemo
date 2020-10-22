package cn.ly.pojo;

import java.util.Objects;

/**
 * @Author LiYun
 * @Date 2020/9/29 19:55
 * @Version 1.0
 */
public class User {
    private int uid;
    private String uname;
    private String pwd;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uid == user.uid &&
                Objects.equals(uname, user.uname) &&
                Objects.equals(pwd, user.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, uname, pwd);
    }

    public User(){
        super();
    }
}
