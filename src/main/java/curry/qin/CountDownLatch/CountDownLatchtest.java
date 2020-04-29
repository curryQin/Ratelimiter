package curry.qin.CountDownLatch;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 利用CountDownLatch实现长连接
 * @author curry
 * @version V1.0
 * @Package curry.qin
 * @date 2020/3/7 14:12
 * @Copyright © 2019-2020 yamibuy
 */
@RestController
public class CountDownLatchtest {

    private Map<Integer, CountDownLatch> userConn = Maps.newHashMap();

    @RequestMapping("countDown/{userId}")
    public void countDownLatch(@PathVariable("userId") Integer userId){
        CountDownLatch countDownLatch = userConn.get(userId);
        if(Objects.isNull(countDownLatch)){
            System.out.println("该用户未初始化连接请求，请初始化连接请求！");
            return;
        }
        countDownLatch.countDown();
    }
    @RequestMapping("initConnection/{userId}")
    public void initConnection(@PathVariable("userId") Integer userId){
        try {
            System.out.println("第一次访问，先不返回数据给客户端，为用户初始化一个60S的短连接和客户端");
            CountDownLatch userCountLatch = new CountDownLatch(1);
            userConn.put(userId, userCountLatch);
            boolean isTimeout = userCountLatch.await(1, TimeUnit.MINUTES);
            if(isTimeout){
                System.out.println("收到客户端数据，已返回数据");
            }else {
                System.out.println("客户端长时间未响应，自动释放连接");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
