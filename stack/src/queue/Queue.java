package queue;

/**
 * @Author LiYun
 * @Date 2020/7/21 14:32
 * 循环队列的实现
 */
public class Queue {
    int front;
    int rear;
    int queueList[];

    public Queue() {
        queueList = new int[5];
        front = 0;
        rear = 0;
    }

    //判空函数
    public boolean isEmpty(){
        if(front == rear){
            return true;
        }
        return false;
    }

    //判满函数
    public boolean isFull(){
        if((rear+1) % 5 == front){
            return true;
        }
        return false;
    }

    //入队
    public void enQueue(int enData){
        if(isFull() == false){
            queueList[rear] = enData;
            rear = (rear+1) % 5;
        }else{
            System.out.println("Error:Queue is full");
            return ;
        }
    }

    //出队

    public void outQueue(){
        if(isEmpty() == false){
            front = (front + 1) % 5;
        }else{
            System.out.println("Error:Queue is empty");
            return;
        }
    }


}
