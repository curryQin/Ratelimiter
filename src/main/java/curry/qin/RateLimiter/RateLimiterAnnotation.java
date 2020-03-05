package curry.qin.RateLimiter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.RateLimiter
 * @date 2020/3/5 10:16
 * @Copyright © 2019-2020 yamibuy
 */
@Target(ElementType.METHOD)//方法注解
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiterAnnotation {
    /**
     * 限流key
     * @return
     */
    String key() default "rate:limiter";
    /**
     * 单位时间限制通过请求数
     * @return
     */
    long limit() default 10;

    /**
     * 过期时间，单位秒
     * @return
     */
    long expire() default 1;

    /**
     * 限流提示语
     * @return
     */
    String message() default "false";
}
