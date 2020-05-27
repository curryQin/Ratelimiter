package curry.qin.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.CountDownLatch
 * @date 2020/5/23 8:49
 * @Copyright © 2019-2020 yamibuy
 */
public class CountDawnLatchConcurrent {
    public static void main(String[] args) {
        // 初始化计数器为1
        CountDownLatch countDownLatch = new CountDownLatch(1);
            for(int i =0;i < 10; i++){
                new Thread(()->{
                    try {
                        countDownLatch.await();
                        System.out.println("Begin Concurrent thread test");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
            countDownLatch.countDown();
        }
}
