package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author LiYun
 * @Date 2020/8/6 9:30
 * 文件存储 ： 接收端
 */
public class UdpFileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方启动中...");
        //1、使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(6666);
        //2、准备容器 封装成DatagramPacket包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //3、阻塞式接收包裹receive(DatagramPacket p)
        server.receive(packet);
        //4、分析数据 将字节数组还原为对应的类型
        //  byte[] getData()
        //          getLength()
        byte[] datas = packet.getData();
        int len = packet.getLength();

        IOUtils.byteArrayToFile(datas,"src/1-copy.png");
        //5、释放资源
        server.close();
    }
}
