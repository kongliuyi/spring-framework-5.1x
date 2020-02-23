package net.riking.imports.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description 自定义逻辑返回需要导入的组件
 * @Author: kongLiuYi
 * @Date: 2020/2/23 16:32
 */
public class MyImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"net.riking.imports.selector.Rabbit"};
	}
}
