package curry.qin.RateLimiter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.RateLimiter
 * @date 2020/3/5 14:03
 * @Copyright © 2019-2020 yamibuy
 */
@RestController
public class RateLimiterControllerTest {

    @RequestMapping("ratelimiter/test")
    @RateLimiterAnnotation(key = "rateLimiter/test",limit = 3,expire = 5000)
    public String ratelimiter(){
        return "hello";
    }
}
