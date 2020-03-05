package curry.qin.ThreadStudy;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.ThreadStudy
 * @date 2020/3/4 13:38
 * @Copyright © 2019-2020 yamibuy
 */
public class ThreadSleepTest {
    private  int i = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程名称"+Thread.currentThread().getName());
                try {
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("结束睡眠"+Thread.currentThread().getName());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程名称"+Thread.currentThread().getName());
            }
        });

        t1.start();
        t2.start();
    }
}
