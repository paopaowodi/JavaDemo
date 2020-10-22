package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @Author LiYun
 * @Date 2020/8/6 9:31
 * 文件上传： 发送端
 *
 */
public class UdpFileClient {
    public static void main(String[] args) throws IOException {
       //1、使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);
        //2、准备数据 转成字节数组
        byte[] datas = IOUtils.fileToByteArray("src/1.png");

        //3、封装成DatagramPacket包裹，需要制定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",6666));
        //4、发送包裹send(DatagramPacket p)
        client.send(packet);
        //5、释放资源
        client.close();
    }
}
