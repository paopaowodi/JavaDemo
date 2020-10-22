package cn.Cooperation;

/**
 * @Author LiYun
 * @Date 2020/9/9 17:51
 * 协作模型:生产者消费者实现方式一：管程法
 */
public class CoTest01 {
    public static void main(String[] args) {
        Container container = new Container();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Productor extends Thread{
    Container container;

    public Productor(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for (int i = 0; i < 100; i++) {
            System.out.println("生产-->"+i+"数据");
            container.push(new Data(i));
        }
    }
}
//消费者
class Consumer extends Thread{
    Container container;

    public Consumer (Container container) {
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费-->"+container.pop().id+"个数据");
        }
    }
}
//缓冲区
class Container{
    Data[] datas = new Data[10];  //存储容器
    int count = 0; //计数器

    //存储 生产
    public synchronized void push(Data data){
        //何时生产 容器存在空间
        //不能生产
        if(count == datas.length){
            try {
                this.wait(); //线程阻塞， 消费者通知生产，解除等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //存在空间 可以生产
        datas[count] = data;
        count++;
        //唤醒消费
        this.notifyAll();
    }
    //获取 消费
    public synchronized Data pop(){
        //何时消费 容器中是否存在数据

        //没有数据，则等待
        if(count == 0){
            try {
                this.wait();  //线程阻塞 生产者通知消费 解除等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //存在数据可以消费
        count--;
        Data data = datas[count];
        this.notifyAll();   //唤醒对方生产
        return data;
    }
}
//数据
class Data{
    int id;

    public Data(int id) {
        this.id = id;
    }
}