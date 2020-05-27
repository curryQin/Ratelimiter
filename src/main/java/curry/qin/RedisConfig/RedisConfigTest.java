package curry.qin.RedisConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.RedisConfig
 * @date 2020/5/23 21:57
 * @Copyright © 2019-2020 yamibuy
 */
@RedisAutoConfig
@SpringBootApplication
public class RedisConfigTest {
    public static void main(String[] args) {
        SpringApplication.run(RedisConfigTest.class);
    }
}
