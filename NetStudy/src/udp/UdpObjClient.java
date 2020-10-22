package udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * @Author LiYun
 * @Date 2020/8/3 16:01
 * 发送端
 *  1.使用DatagramSocket 指定端口 创建接收端
 *  2.将引用类型 转成字节数组
 *  3.封装成DatagramPacket 包裹，需要制定目的地
 *  4.发送包裹 send(DatagramPacket p)
 *  5.释放资源
 */
public class UdpObjClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中...");
        //1.使用DatagramSocket 指定端口 创建接收端
        DatagramSocket client = new DatagramSocket(8888);
        //2.将基本数据转成字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(baos));
        //对象
        dos.writeObject("我选择了其中一条");
        dos.writeObject(new Date());
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













