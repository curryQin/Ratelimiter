package curry.qin.RedisConfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.RedisConfig
 * @date 2020/5/23 21:57
 * @Copyright © 2019-2020 yamibuy
 */
@RedisAutoConfig
public class RedisConfigTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(RedisConfigTest.class);
        System.out.println(ctx.getBean("myBean").getClass().getName());
    }
    @Bean
    public String myBean(){
        return  new String("hello");
    }
}
