package curry.qin.RedisConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.RedisConfig
 * @date 2020/5/24 14:25
 * @Copyright © 2019-2020 yamibuy
 */
@Import(RedisSelector.class)
@Configuration
public @interface RedisAutoConfig {
}
