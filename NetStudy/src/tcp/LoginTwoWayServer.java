package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author LiYun
 * @Date 2020/8/6 14:46
 * 模拟登录 双向
 * 创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接accept()
 * 3、操作: 输入输出流操作
 * 4、释放资源
 */
public class LoginTwoWayServer {
    public static void main(String[] args) throws IOException {
        System.out.println("------Server------");
        //1、指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2、阻塞式等待连接accept()
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        //3、操作: 输入输出流操作
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String datas = dis.readUTF();
        String uname = "";
        String upwd = "";
        //分析
        String[] dataArray = datas.split("&");
        for(String info: dataArray){
            String[] userInfo = info.split("=");
            if(userInfo[0].equals("uname")){
                System.out.println("你的用户名为："+ userInfo[1]);
                uname = userInfo[1];
            }else if(userInfo[0].equals("upwd")){
                System.out.println("您的密码为："+userInfo[1]);
                upwd = userInfo[1];
            }
        }
        //双向输出
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        if(uname.equals("ly") && upwd.equals("haha")){ //成功
            dos.writeUTF("登陆成功！");
        }else{ // 失败
            dos.writeUTF("用户名或密码错误");
        }

        //4、释放资源
        dis.close();
        client.close();

        server.close();
    }
}
