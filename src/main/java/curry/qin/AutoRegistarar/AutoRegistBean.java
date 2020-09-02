package curry.qin.AutoRegistarar;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.AutoRegistarar
 * @date 2020/7/10 13:01
 * @Copyright © 2019-2020 yamibuy
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface AutoRegistBean {
}
