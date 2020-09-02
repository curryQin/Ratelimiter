package curry.qin.AutoRegistarar;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.AutoRegistarar
 * @date 2020/7/10 13:04
 * @Copyright © 2019-2020 yamibuy
 */
public class MyAutoRegistarar implements ImportBeanDefinitionRegistrar,EnvironmentAware,ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        resourceLoader = resourceLoader;
    }

    /***
     *  实现registerBeanDefinitions方法。但是有一个问题，我们并不知道需要register哪些bean。
     *  这里我们还需要借助一个类ClassPathBeanDefinitionScanner，也就是扫描器，通过扫描器获取我们需要注册的bean。
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //1.重写指定扫描的路径
//        MyAnnotationScanner scanner = new MyAnnotationScanner(registry, false);
//        scanner.setResourceLoader(resourceLoader);
//        scanner.registerFilters();
//        scanner.doScan("curry.qin");

        //2.获取当前类的包名作为扫描路径
        String pack = this.getClass().getPackage().getName();
        ClassPathBeanDefinitionScanner scanner1 = new ClassPathBeanDefinitionScanner(registry);
//        scanner1.addIncludeFilter(new AnnotationTypeFilter(AutoRegistBean.class));
        scanner1.scan(pack);
        //手动创建GenericBeanDefinition手动注册
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(TestAutoReister.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue("value", "132132");
        registry.registerBeanDefinition("hello",beanDefinition);
    }
}
