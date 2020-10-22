package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author LiYun
 * @Date 2020/9/6 19:07
 * @Version 1.0
 */
public class Chat01 {
    public static void main(String[] args) throws IOException {
        System.out.println("------Server------");
        //1、指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2、阻塞式等待连接accept()
        while(true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");

            //接收消息
            new Thread(() -> {
                DataInputStream dis = null;
                DataOutputStream dos = null;
                try {
                    dis = new DataInputStream(client.getInputStream());
                    dos = new DataOutputStream(client.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                boolean isRunning = true;
                while (isRunning) {
                    String msg = null;
                    try {
                        msg = dis.readUTF();
                        //返回消息
                        dos.writeUTF(msg);
                        //释放资源
                        dos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

                try {
                    if(dos != null){
                    dos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(dis != null){
                        dis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(client != null){
                        client.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();




        }


    }
}

