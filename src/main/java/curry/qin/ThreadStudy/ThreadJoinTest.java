package curry.qin.ThreadStudy;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.ThreadStudy
 * @date 2020/3/5 16:07
 * @Copyright © 2019-2020 yamibuy
 */
public class ThreadJoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1执行完毕！");
            }
        }) {};

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2执行完毕！");
            }
        }) {};
        t2.start();
        t1.start();

        //main主线程等待线程1执行完毕
        t1.join();
        //main主线程等待线程2执行完毕
        t2.join();
        System.out.println("全部执行完！");
    }
}
