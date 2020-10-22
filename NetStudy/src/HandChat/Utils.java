package HandChat;

import java.io.Closeable;

/**
 * @Author LiYun
 * @Date 2020/9/6 19:43
 * @Version 1.0
 */
public class Utils {
    public static void close(Closeable... targets){
        for(Closeable target:targets){
            try {
                if(null != target){
                    target.close();
                }
            }catch (Exception e){

            }
        }
    }
}
