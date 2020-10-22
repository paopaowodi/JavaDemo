package cn.ThreadStudy;

/**
 * @Author LiYun
 * @Date 2020/9/8 17:51
 * @Version 1.0
 */
public class LambdaTest01 {
    static class Like2 implements Inface{

        @Override
        public void lambda() {
            System.out.println("静态内部类 + lambda2");
        }
    }


    public static void main(String[] args) {
        Inface like = new Like();
        like = new Like2();
        like.lambda();

        //方法内部类
        class Like3 implements Inface{

            @Override
            public void lambda() {
                System.out.println("方法内部类 lambda3");
            }
        }
        like = new Like3();
        like.lambda();

        //匿名内部类
        like = new Inface() {

            @Override
            public void lambda() {
                System.out.println("匿名内部类 lambda4");
            }
        };
        like.lambda();

        //lambda
        like = ()->{
                System.out.println("匿名内部类 lambda4");
        };
    }

}

interface Inface{
    void lambda();   //接口只能有一个方法，多了会报错

}
//外部类
class Like implements Inface{

    @Override
    public void lambda() {
        System.out.println("外部类+lambda");
    }
}
