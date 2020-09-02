package curry.qin.AutoRegistarar;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.AutoRegistarar
 * @date 2020/7/14 13:37
 * @Copyright © 2019-2020 yamibuy
 */
public class MyImportSelector implements ImportSelector,BeanClassLoaderAware {

    private ClassLoader beanClassLoader;
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        AnnotationAttributes attributes = getAttributes(importingClassMetadata);
        List<String> configurations = getCandidateConfigurations(importingClassMetadata,
                attributes);
        return configurations.toArray(new String[configurations.size()]);

    }
    protected AnnotationAttributes getAttributes(AnnotationMetadata metadata) {
        String name = getAnnotationClass().getName();
        AnnotationAttributes attributes = AnnotationAttributes
                .fromMap(metadata.getAnnotationAttributes(name, true));
        Assert.notNull(attributes,
                "No auto-configuration attributes found. Is " + metadata.getClassName()
                        + " annotated with " + ClassUtils.getShortName(name) + "?");
        return attributes;
    }
    protected Class<?> getAnnotationClass() {
        return MyAutoConfig.class;
    }

    protected List<String> getCandidateConfigurations(AnnotationMetadata metadata,
                                                      AnnotationAttributes attributes) {
        List<String> configurations = SpringFactoriesLoader.loadFactoryNames(
                getSpringFactoriesLoaderFactoryClass(), getBeanClassLoader());
        Assert.notEmpty(configurations,
                "No auto configuration classes found in META-INF/spring.factories. If you "
                        + "are using a custom packaging, make sure that file is correct.");
        return configurations;
    }

    protected Class<?> getSpringFactoriesLoaderFactoryClass() {
        return MyAutoConfig.class;
    }

    protected ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
    }
}
