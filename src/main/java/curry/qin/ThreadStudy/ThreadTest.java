package curry.qin.ThreadStudy;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.ThreadStudy
 * @date 2020/4/2 13:50
 * @Copyright © 2019-2020 yamibuy
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque queue = new LinkedBlockingDeque<>(10);
        for(int i = 0; i< 10; i++ ){
            queue.put(i);
        }
        for(int i =0;i<10;i++){
                Thread t = new Thread(()-> System.out.println(queue.poll()));
                t.start();
            }
    }
//        CountDownLatch countDownLatch = new CountDownLatch(10);
//        for(int i =0;i<10;i++){
//            int temp = i;
//            if(countDownLatch.getCount() == 10-i){
//                Thread t = new Thread(()-> {
//                    System.out.println(temp);
//                    countDownLatch.countDown();
//                });
//                t.start();
//            }else {
//                countDownLatch.await();
//            }
//            Thread.sleep(200);
//        }
//        for(int i = 0;i<10;i++){
//            threadSystemOut(i);
//            Thread.currentThread().sleep(200);
//        }

}
