package udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @Author LiYun
 * @Date 2020/8/3 16:01
 * 发送端
 *  1.使用DatagramSocket 指定端口 创建接收端
 *  2.将基本类型 转成字节数组
 *  3.封装成DatagramPacket 包裹，需要制定目的地
 *  4.发送包裹 send(DatagramPacket p)
 *  5.释放资源
 */
public class UdpTypeClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中...");
        //1.使用DatagramSocket 指定端口 创建接收端
        DatagramSocket client = new DatagramSocket(8888);
        //2.将基本数据转成字节数组
        //写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        java.io.DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        //操作类型+ 数据
        dos.writeUTF("树林里分出来两条路");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();
        byte[] datas = baos.toByteArray();

        //3.封装成DatagramPacket 包裹，需要制定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",6666));

        // 4. 发送包裹 send(DatagramPacket p)
        client.send(packet);
        // 5.释放资源
        client.close();
    }
}













