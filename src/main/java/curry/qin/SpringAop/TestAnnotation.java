package curry.qin.SpringAop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.SpringAop
 * @date 2020/3/5 9:07
 * @Copyright © 2019-2020 yamibuy
 */
@Target(ElementType.METHOD)//方法注解
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
    //接口名称
    String name()  default "";

    boolean isLog() default false;

    int channel() default 1;
}
