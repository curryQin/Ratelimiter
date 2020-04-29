package curry.qin.ThreadPool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.ThreadPool
 * @date 2020/4/22 16:33
 * @Copyright © 2019-2020 yamibuy
 */
public class ThreadPoolTest {
    public static void main(String[] args) {

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);
        //周期性执行任务
        scheduledThreadPoolExecutor.scheduleAtFixedRate(
                //执行任务
                ()-> System.out.println("执行"),
                //首次执行延期时间
                0 ,
                //任务之间执行时间间隔
                1000 ,
                //毫秒  时间单位
                TimeUnit.MILLISECONDS);
    }
}
