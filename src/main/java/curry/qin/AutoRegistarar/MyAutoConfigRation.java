package curry.qin.AutoRegistarar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.AutoRegistarar
 * @date 2020/7/15 14:35
 * @Copyright © 2019-2020 yamibuy
 */
public class MyAutoConfigRation {

    @Bean
    public TestAutoReister testAutoReister(){
        return new TestAutoReister();
    }
}
