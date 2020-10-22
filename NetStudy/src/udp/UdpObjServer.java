package udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * @Author LiYun
 * @Date 2020/8/3 16:00
 *
 * 引用类型：接收端 服务端
 * 1.使用DatagramSocket 指定端口 创建接收端
 * 2.准备容器 封装成 DataGramPacket 包裹
 * 3.阻塞式接收包裹 receive(DatagramPacket p)
 * 4.分析数据 将字节数组还原为对应的类型
 *      byte[] getData()
 *             getLength()
 * 5.释放资源
 */
public class UdpObjServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中...");
        //1.使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(6666);
        //2.准备容器 封装成DatagramPacket 包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //3. 阻塞式接收包裹 receive(DatagramPacket p)
         server.receive(packet);//阻塞式
        //4.分析数据 将字节数组还原为对应的类型
        //     byte[] getData()
        //            getLength()
        byte[] datas = packet.getData();
        int len = packet.getLength();
        //读取--->反序列化
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //对象的数据还原
        Object str = dis.readObject();
        Object date = dis.readObject();

        if(str instanceof String){
            String strObj = (String)str;
            System.out.println(strObj);
        }
        if(date instanceof Date){
            Date dateObj = (Date)date;
            System.out.println(dateObj);
        }


        // 5.释放资源
        server.close();
    }
}
