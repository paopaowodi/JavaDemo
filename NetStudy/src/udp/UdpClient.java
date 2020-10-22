package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @Author LiYun
 * @Date 2020/8/3 16:01
 * 发送端
 *  1.使用DatagramSocket 指定端口 创建接收端
 *  2.准备数据 一定要转成字节数组
 *  3.封装成DatagramPacket 包裹，需要制定目的地
 *  4.发送包裹 send(DatagramPacket p)
 *  5.释放资源
 */
public class UdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中...");
        //1.使用DatagramSocket 指定端口 创建接收端
        DatagramSocket client = new DatagramSocket(8888);
        //2.准备数据 一定要转成字节数组
        String data = "吹梦到西洲";
        byte[] datas = data.getBytes();
        //3.封装成DatagramPacket 包裹，需要制定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",6666));

        // 4. 发送包裹 send(DatagramPacket p)
        client.send(packet);
        // 5.释放资源
        client.close();
    }
}













