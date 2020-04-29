package curry.qin.ThreadStudy;

import java.util.concurrent.Semaphore;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.ThreadStudy
 * @date 2020/3/4 13:38
 * @Copyright © 2019-2020 yamibuy
 */
public class ThreadSleepMethodTest {
    //Semaphore可以控制某个资源可被同时访问的个数
    private static Semaphore semaphore = new Semaphore(1);

    private  int i= 10;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        semaphore.acquire();
                        //取得obj对象锁的才可以继续执行，否则阻塞
                        System.out.println(Thread.currentThread().getName()+"取得对象锁");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"拿到许可执行");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

    class Thread1 implements Runnable{

        @Override
        public void run() {
            for(int j =0;j< 10;j++){
                i = i++;
                System.out.println(i);
            }
        }
    }
    class Thread2 implements Runnable{

        @Override
        public void run() {
            for(int j =0;j< 10;j++){
                i = i++;
                System.out.println(i);
            }
        }
    }
}
