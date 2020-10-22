package tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author LiYun
 * @Date 2020/8/6 14:46
 * 模拟登录 单向
 * 创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接accept()
 * 3、操作: 输入输出流操作
 * 4、释放资源
 */
public class LoginServer {
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
        //分析
        String[] dataArray = datas.split("&");
        for(String info: dataArray){
            String[] userInfo = info.split("=");
            System.out.println(userInfo[0]+"--"+userInfo[1]);
        }
        //4、释放资源
        dis.close();
        client.close();

        server.close();
    }
}
