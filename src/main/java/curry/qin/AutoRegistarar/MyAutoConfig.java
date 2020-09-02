package curry.qin.AutoRegistarar;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfigurationImportSelector;
import org.springframework.context.annotation.Import;

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
 * @date 2020/7/15 14:45
 * @Copyright © 2019-2020 yamibuy
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import(MyImportSelector.class)
public @interface MyAutoConfig {
}
