package net.riking.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 *自定义逻辑返回需要导入的组件
 */
public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        return new String[]{"net.riking.bean.CarBeanPostProcessor"};
    }
}