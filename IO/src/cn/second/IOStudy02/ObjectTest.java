package cn.second.IOStudy02;

import java.io.*;
import java.util.Date;

/**
 * @Author LiYun
 * @Date 2020/8/5 15:18
 *
 * 对象流：
 * 1、先写出后读取
 * 2、读取的顺序与写出保持一致
 * 3、不是所有对象都可以序列化 Serializable
 */
public class ObjectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写出--->序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(baos));
        //操作类型+ 数据
        dos.writeUTF("树林里分出来两条路");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        //对象
        dos.writeObject("我选择了其中一条");
        dos.writeObject(new Date());
        Employee emp = new Employee("李小花",4000);
        dos.writeObject(emp);
        dos.flush();
        byte[] datas = baos.toByteArray();
        //读取--->反序列化
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //顺序写出一致
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        //对象的数据还原
        Object str = dis.readObject();
        Object date = dis.readObject();
        Object employee = dis.readObject();

        if(str instanceof String){
            String strObj = (String)str;
            System.out.println(strObj);
        }
        if(date instanceof Date){
            Date dateObj = (Date)date;
            System.out.println(dateObj);
        }
        if(employee instanceof Employee){
            Employee empObj = (Employee)employee;
            System.out.println(empObj.getName()+"--->"+empObj.getSalary());
        }
        System.out.println(msg);
    }
}
//javabeen
class Employee implements Serializable{
    private  transient String name; // transient 该数据不需要序列化
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
