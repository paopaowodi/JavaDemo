package cn.ThreadStudy03syn;

/**
 * @Author LiYun
 * @Date 2020/9/9 16:50
 * 影院
 */
public class HappyCinema {
    public static void main(String[] args) {
        Cinema c = new Cinema(20,"xx影院");
        new Thread(new Customer(c,2),"李").start();
        new Thread(new Customer(c,2),"陈").start();

    }
}
class Customer implements Runnable{
    Cinema cinema;
    int seats;

    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema){
        boolean flag = cinema.bookTicket(seats);
        if(flag){
            System.out.println("购票成功"+Thread.currentThread().getName()+"-<位置为:"+
                    seats);
        }else{
            System.out.println("购票失败"+Thread.currentThread().getName()+"--<位置不够");
        }
        }
    }
}


class Cinema {
    int available;  //位置
    String name;   //名称

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }
    public boolean bookTicket(int seats){
        System.out.println("可用位置为:"+available);
        if(seats > available){
            return false;
        }
        available -= seats;
        return true;
    }
}