package curry.qin.RedisConfig;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.util.List;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.RedisConfig
 * @date 2020/5/24 14:28
 * @Copyright © 2019-2020 yamibuy
 */
public class RedisSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        AnnotationAttributes attributes = getAttributes(importingClassMetadata);
        List<String> configurations = getCandidateConfigurations(importingClassMetadata,
                attributes);
        return configurations.toArray(new String[configurations.size()]);
    }

    protected List<String> getCandidateConfigurations(AnnotationMetadata metadata,
                                                      AnnotationAttributes attributes) {
        List<String> configurations = SpringFactoriesLoader.loadFactoryNames(
                RedisSelector.class, RedisSelector.class.getClassLoader());
        Assert.notEmpty(configurations,
                "No auto configuration classes found in META-INF/spring.factories. If you "
                        + "are using a custom packaging, make sure that file is correct.");
        return configurations;
    }

    protected AnnotationAttributes getAttributes(AnnotationMetadata metadata) {
        String name = RedisSelector.class.getName();
        AnnotationAttributes attributes = AnnotationAttributes
                .fromMap(metadata.getAnnotationAttributes(name, true));
        Assert.notNull(attributes,
                "No auto-configuration attributes found. Is " + metadata.getClassName()
                        + " annotated with " + ClassUtils.getShortName(name) + "?");
        return attributes;
    }
}
