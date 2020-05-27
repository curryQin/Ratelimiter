package curry.qin;

import curry.qin.RedisConfig.RedisAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
/*该注解表示启用feign调用远程服务*/
@EnableFeignClients
@RedisAutoConfig
///*启动使用服务发现和注册功能 */
//@EnableDiscoveryClient
/*启用熔断器功能*/
@EnableHystrix
public class EurekaConsumer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumer.class,args);
    }
}
