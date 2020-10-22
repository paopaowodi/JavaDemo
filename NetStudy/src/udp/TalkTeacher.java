package udp;

/**
 * @Author LiYun
 * @Date 2020/8/6 10:47
 * 加入多线程，实现双向交流 模拟在线咨询
 */
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkReceive(9999,"学生")).start();//接收

        new Thread(new TalkSend(6789,"localhost",7777)).start();//发送
    }
}
