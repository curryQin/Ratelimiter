package curry.qin.RibbonConfig;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/***
 * 使用Ribbon+RestTemplate进行远程服务调用
 * ribbon负责负载均衡，RestTemplate进行发送请求
 * 在进行远程服务调用字需要将我们的RestTemplate注入进去即可
 * 这个类是一个配置类，相当于<bean id="restTemplate" loadBalaced="true"></bean>
 */
@Configuration
public class RibbonConfig {

    @Bean
//    加上负载均衡注解
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
