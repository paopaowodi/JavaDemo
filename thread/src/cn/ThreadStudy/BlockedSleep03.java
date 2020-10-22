package cn.ThreadStudy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author LiYun
 * @Date 2020/9/8 20:21
 *
 */
public class BlockedSleep03 {
    public static void main(String[] args) throws InterruptedException {
        //倒计时
        Date endTime = new Date(System.currentTimeMillis()+1000*10);
        long end = endTime.getTime();
        while(true){

            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime()-1000);
            if(end - 10000 > endTime.getTime()){
                break;
            }
        }
    }
    public static void test() throws InterruptedException{

    }
}
