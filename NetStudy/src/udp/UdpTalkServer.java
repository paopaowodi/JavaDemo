package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author LiYun
 * @Date 2020/8/3 16:00
 *
 * 多次交流：接收端 服务端
 * 1.使用DatagramSocket 指定端口 创建接收端
 * 2.准备容器 封装成DataGramPacket 包裹
 * 3. 阻塞式接收包裹 receive(DatagramPacket p)
 * 4.分析数据
 *      byte[] getData()
 *             getLength()
 * 5.释放资源
 */
public class UdpTalkServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中...");
        //1.使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(6666);
        while(true){
        //2.准备容器 封装成DatagramPacket 包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //3. 阻塞式接收包裹 receive(DatagramPacket p)
         server.receive(packet);//阻塞式
        //4.分析数据
        //     byte[] getData()
        //            getLength()
        byte[] datas = packet.getData();
        int len = packet.getLength();
        String data = new String(datas,0,len);
        System.out.println(data);
            if(data.equals("bye")){
                break;
            }
        }
        // 5.释放资源
        server.close();
    }
}
