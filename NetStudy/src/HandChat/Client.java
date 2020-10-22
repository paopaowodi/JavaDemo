package HandChat;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author LiYun
 * @Date 2020/8/6 14:51
 * 熟悉流程
 * 创建客户端
 * 1、建立连接：使用Socket创建客户端 + 服务器的地址和端口
 * 2、操作: 输入输出流操作
 * 3、释放资源
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("------Client------");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入用户名:");
        String name = br.readLine();
        //1、建立连接：使用Socket创建客户端 + 服务器的地址和端口
        Socket client = new Socket("localhost",8888);
        //2、客户端发消息
        new Thread(new Send(client,name)).start();
        new Thread(new Receive(client)).start();

    }
}
