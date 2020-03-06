package curry.qin.ThreadStudy;
/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.ThreadStudy
 * @date 2020/3/4 13:38
 * @Copyright © 2019-2020 yamibuy
 */
public class ThreadSleepTest {
    private static final Object obj = new Object();

    private  int i= 10;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //取得obj对象锁的才可以继续执行，否则阻塞
                synchronized(obj){
                    System.out.println(Thread.currentThread().getName()+"取得对象锁");
                    try {
                        //thread1休息，cpu可执行其他任务 但是确没有释放对obi对象的锁，
                        // 遇到获取obj对象锁的才可以执行的得释放锁之后才能执行
                        System.out.println(Thread.currentThread().getName()+"休息");
                        Thread.currentThread().sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"休息完毕，释放掉对象锁");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println(Thread.currentThread().getName()+"取得对象锁");
                    System.out.println(Thread.currentThread().getName()+"业务处理");
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
