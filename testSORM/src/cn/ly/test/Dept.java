package cn.ly.test;

/**
 * @Author LiYun
 * @Date 2020/9/15 21:08
 * @Version 1.0
 */
public class Dept {
    private Integer id;
    private String dname;
    private String address;

    public Dept(Integer id, String dname, String address) {
        this.id = id;
        this.dname = dname;
        this.address = address;
    }

    public Dept(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
