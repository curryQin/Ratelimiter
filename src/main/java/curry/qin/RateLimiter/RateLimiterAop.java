package curry.qin.RateLimiter;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.RateLimiter
 * @date 2020/3/5 10:19
 * @Copyright © 2019-2020 yamibuy
 * 使用redis进行接口限流切面实现，对于加上了ratelimitAnnotation的方法进行限流
 */
@Aspect
@Order(1)
@Component
public class RateLimiterAop {

    private static final Logger LOGGER = LoggerFactory.getLogger(RateLimiterAop.class);

    @Autowired
    RedisTemplate redisTemplate;

    /***
     * redis加载外部资源文件类
     */
    private DefaultRedisScript<Long> getRedisScript;

    @PostConstruct
    public void init(){
        LOGGER.info("RateLimiterAop初始化，执行redis外部加载lua脚本");
        getRedisScript = new DefaultRedisScript<>();
        getRedisScript.setResultType(Long.class);
        getRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("rateLimter.lua")));
        LOGGER.info("RateLimiterAop[分布式限流处理器]脚本加载完成");
    }
    @PreDestroy
    public void destory(){
        LOGGER.info("RateLimiterAop 销毁");
    }
    /***
     * 拦截被rateLimierAnnotation注解修饰的方法
     * @param proceedingJoinPoint
     * @param rateLimiter
     */
    @Around("@annotation(rateLimiter)")
    public Object limtAop(ProceedingJoinPoint proceedingJoinPoint,RateLimiterAnnotation rateLimiter) throws Throwable {
         //限流的key
        String limitKey = rateLimiter.key();
        Preconditions.checkNotNull(limitKey);
        // 限流阈值
        long limitTimes = rateLimiter.limit();
        // 限流超时时间
        long expireTime = rateLimiter.expire();
        LOGGER.info("限流配置：key：{}，limit:{},expireTime:{},message:{}",limitKey,limitTimes,expireTime,rateLimiter.message());

        //构建lua脚本执行时候需要的参数
        List<String> keyList = Lists.newArrayList();
        //设置key值为注解中的值
        keyList.add(limitKey);
        //redis执行lua脚本（返回0或者1，具体参照lua脚本），也是原子操作，并且设置限流的key到redis，并设置key过期时间为阈值
        Long result = (Long) redisTemplate.execute(getRedisScript, keyList,expireTime,limitTimes);
        if(result == 0){
            String msg = "由于超过单位时间=" + expireTime + "-允许的请求次数=" + limitTimes + "[触发限流]";
            LOGGER.info(msg);
            return "false";
        }
        LOGGER.info("limtAop[分布式限流处理器]限流执行结果-result={},请求[正常]响应", result);
        //继续处理目标方法业务
        return proceedingJoinPoint.proceed();
    }
}
