package HandChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author LiYun
 * @Date 2020/9/6 19:07
 * 群聊 ：服务端
 */
public class Chat {
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("------Server------");
        //1、指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2、阻塞式等待连接accept()
        while(true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            Channel c = new Channel(client);
            all.add(c);  //管理所有的成员
            new Thread(c).start();


        }


    }
    //一个客户代表一个Channel
    static class Channel implements Runnable{
        private   DataInputStream dis ;
        private   DataOutputStream dos ;
        private Socket client;
        private boolean isRunning ;
        private String name;
        public Channel(Socket client){
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
                //获取名称
                this.name = receive();
            } catch (IOException e) {
               release();
            }
        }
        //接收消息
        private String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("接收消息出问题");
               release();
            }
            return msg;
        }
        //发送消息
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("发送消息出错");
                release();
            }
        }
        //群聊 ： 获取自己的消息发给其他人
        private void sendOthers (String msg ){
            for(Channel other:all){
                if(other == this){   //自己
                    continue;
                }
                other.send(this.name+"说："+msg);
            }
        }
        //释放资源
        private void release(){
            this.isRunning = false;
            Utils.close(dis,dos,client);
        }

        @Override
        public void run() {
            while(isRunning){
                String msg = receive();
                if(!msg.equals("")){
                    sendOthers(msg);
                }
            }
        }
    }
}

