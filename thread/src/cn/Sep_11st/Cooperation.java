package cn.Sep_11st;

import com.sun.deploy.net.proxy.ProxyUnavailableException;

/**
 * @Author LiYun
 * @Date 2020/9/11 21:34
 * 生产者消费者模式 —— 管程法
 * 线程通信的应用：生产者/消费者问题
 *
 *  生产者(Productor)将产品交给仓库(Container)，而消费者(Customer)从仓库处取走产品，
 *  仓库一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，仓库
 *  会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
 *  了，仓库会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 */
public class Cooperation {
    public static void main(String[] args) {
        Container container = new Container();
        new Producer(container).start();
        new Customer(container).start();
    }

}
//消费者
class Customer extends Thread{
    Container container ;

    public Customer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        //消费
        for (int i = 0; i < 50; i++) {
            System.out.println("正在消费第 "+container.pop().id+" 个商品");
        }
    }
}

//生产者
class Producer extends Thread{
    Container container ;

    public Producer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for (int i = 0; i < 30; i++) {
            System.out.println("生产 --->" + i + "本书");
            container.push(new Book(i));
        }

    }
}

//缓冲区
class Container{
    Book[] books = new Book[20];
    int count = 0; //计数器

    //存
    public synchronized void push(Book book){
        //存在空间可生产
        if(count == books.length){
            try {
                this.wait();    //消费者通知生产 解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        books[count++] = book;
        this.notifyAll();
    }
    //取
    public synchronized Book pop(){
        //何时消费 是否存在数据
        if(count == 0){
            try {
                this.wait();  //生产者通知消费结束阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Book book = books[count];
        this.notifyAll();
        return book;
    }

}

//数据
class  Book{
    int id;

    public Book(int id) {
        this.id = id;
    }
}