package cn.ThreadStudy;

/**
 * @Author LiYun
 * @Date 2020/9/8 20:55
 * 观察线程状态
 */
public class AllState {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for(int i = 0; i < 5; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("...");
        });
        //观察状态
        Thread.State state = t.getState();
        System.out.println(state); // NEW

        t.start();
        state = t.getState();
        System.out.println(state); // RUNNABLE

//        while(state != Thread.State.TERMINATED){
//            Thread.sleep(200);
//            state = t.getState();
//            System.out.println(state); // RUNNABLE
//
//        }

        while(true){
            int num = Thread.activeCount();
            if(num == 1){
                break;
            }
            System.out.println(num);
            Thread.sleep(200);
            state = t.getState();
            System.out.println(state); // RUNNABLE

        }

//
//        state = t.getState();
//        System.out.println(state); // TERMINATED

    }
}
