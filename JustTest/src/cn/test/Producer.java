package cn.test;

/**
 * @Author LiYun
 * @Date 2020/9/13 17:41
 * 生产者与消费者
 */
public class Producer {
    public static void main(String[] args) {
        Container container = new Container();
        new Productor(container).start();
        new Customer(container).start();
    }
}

class Productor extends Thread{
    Container container = new Container();

    public Productor(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for (int i = 0; i < 20; i++) {
            System.out.println("正在生产第 "+ i +" 个商品");
            container.push(new Items(i));
        }
    }
}

class Customer extends Thread{
    Container container;

    public Customer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        //消费
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第"+container.pop().id+"个商品");
        }

    }
}

class Container {
    Items[] items = new Items[10];
    int count = 0;

    //生产

    public synchronized void push(Items item){
        if(count == items.length){
            //不生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        items[count++] = item;
        notifyAll();
    }

    //消费
    public synchronized Items pop(){
        if(count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Items temp = items[--count];
        notifyAll();
        return temp;
    }
}

class Items{
    int id;
    String name;

    public Items(int id) {
        this.id = id;
    }
}