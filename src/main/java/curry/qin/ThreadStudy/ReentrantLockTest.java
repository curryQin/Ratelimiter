package curry.qin.ThreadStudy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.ThreadStudy
 * @date 2020/3/11 9:54
 * @Copyright © 2019-2020 yamibuy
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        Thread thread3 = new Thread() {
            @Override
            public void run() {
                while (true){
                    try {
                        lock.lock();
                        System.out.println("线程3获得锁开始执行");
                        Thread.currentThread().sleep(1000);//sleep只会让出cpu资源，不会释放对象锁
                        System.out.println("线程3执行完毕");
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                        lock.unlock();
                     }
                    }
            }
        };

        Thread thread4 = new Thread() {
            @Override
            public void run() {
                while (true){
                    try {
                         lock.lock();
                        System.out.println("线程4获得锁开始执行");
                        Thread.currentThread().sleep(1000);//sleep只会让出cpu资源，不会释放对象锁
                        System.out.println("线程4执行完毕");
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                        lock.unlock();//释放该对象的锁
                    }
                    }
            }
        };
        thread4.start();
        thread3.start();

    }
}
