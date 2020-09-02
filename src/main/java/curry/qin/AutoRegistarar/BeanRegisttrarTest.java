package curry.qin.AutoRegistarar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin
 * @date 2020/7/10 13:00
 * @Copyright © 2019-2020 yamibuy
 */
@Configuration
@MyAutoConfig
//@Import(MyAutoRegistarar.class)
//@Import(MyImportSelector.class)
public class BeanRegisttrarTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanRegisttrarTest.class);
        System.out.println(ctx.getBean("testAutoReister"));
//        TestAutoReister test = (TestAutoReister) ctx.getBean("hello");
//        System.out.println(test.getValue());
    }
}
