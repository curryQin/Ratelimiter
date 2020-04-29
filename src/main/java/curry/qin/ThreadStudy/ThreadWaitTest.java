package curry.qin.ThreadStudy;

import java.util.Objects;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.ThreadStudy
 * @date 2020/3/11 9:54
 * @Copyright © 2019-2020 yamibuy
 */
public class ThreadWaitTest {

    private static final Object obj = new Object();


    public static void main(String[] args) {
        Thread thread3 = new Thread() {
            @Override
            public void run() {
                while (true){
                    synchronized (obj){
                        System.out.println("线程3获得锁开始执行");
                        try {
                                Thread.currentThread().sleep(1000);//sleep只会让出cpu资源，不会释放对象锁
                                System.out.println("线程3执行完毕");
                                obj.notify();//通知其他的单个线程
                                obj.wait();//释放该对象的锁
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Thread thread4 = new Thread() {
            @Override
            public void run() {
                while (true){
                    synchronized (obj){
                        System.out.println("线程4获得锁开始执行");
                        try {
                            Thread.currentThread().sleep(1000);//sleep只会让出cpu资源，不会释放对象锁
                            System.out.println("线程4执行完毕");
                            obj.notify();//释放该对象的锁
                            obj.wait();//释放该对象的锁
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        };
        thread3.start();
        thread4.start();
    }
}
