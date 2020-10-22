package tcp;

import java.io.*;
import java.net.Socket;

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
    public static void main(String[] args) throws IOException {
        System.out.println("------Client------");
        //1、建立连接：使用Socket创建客户端 + 服务器的地址和端口
        Socket client = new Socket("localhost",8888);
        //2、客户端发消息
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        boolean isRunning = true;
        while(isRunning){
            String msg = console.readLine();
            dos.writeUTF(msg);
            dos.flush();
            //获取消息
            msg = dis.readUTF();
            System.out.println(msg);
        }
        //3、释放资源
        dos.close();
        dis.close();
        client.close();
    }
}
