package curry.qin.AutoRegistarar;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.AutoRegistarar
 * @date 2020/7/10 13:09
 * @Copyright © 2019-2020 yamibuy
 *
 * 指定扫描类信息
 */
public class MyAnnotationScanner extends ClassPathBeanDefinitionScanner {


    public MyAnnotationScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);
    }

    /***
     * 指定我们注解标注的类,加到扫描类型中
     */
    protected void registerFilters() {
        addIncludeFilter(new AnnotationTypeFilter(AutoRegistBean.class));
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}
