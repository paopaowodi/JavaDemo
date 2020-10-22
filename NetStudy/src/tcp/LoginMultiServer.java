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
public class LoginMultiServer {
    public static void main(String[] args) throws IOException {
        System.out.println("------Server------");
        //1、指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        boolean isRunning = true;
        //2、阻塞式等待连接accept()
        while(isRunning) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            new Thread(new Channel(client)).start();
        }
        server.close();
    }
}

class Channel implements Runnable{

    private Socket client;
    //输入流
    private DataInputStream dis;
    //输出流
    private DataOutputStream dos;
    public Channel(Socket client){
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
            //输出
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            try {
                client.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }
    //接收数据
    private String receive(){
        String datas = "";
        try {
            datas = dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }
    //释放资源
    private void release(){
        try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //发送数据
    private String send(String msg){
        try {
            dos.writeUTF("登录成功！");
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "成功";
    }

    @Override
    public void run() {
        //3、操作: 输入输出流操作
        String datas = null;
        try {
            datas = dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        if(uname.equals("ly") && upwd.equals("haha")){ //成功
            send("登陆成功！");
        }else{ // 失败
            send("用户名或密码错误");
        }

        //4、释放资源
        release();

}
}

