package loc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author LiYun
 * @Date 2020/8/3 15:24
 * 网络爬虫原理
 */
public class SpiderTest01 {
    public static void main(String[] args) throws Exception {
        //获取URL
        URL url = new URL("https://www.jd.com");

        //下载资源
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String msg = null;
        while(null != (msg = br.readLine())){
            System.out.println(msg);
        }
        br.close();
        //分析
        //处理
    }
}
