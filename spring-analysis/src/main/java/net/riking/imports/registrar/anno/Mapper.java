package net.riking.imports.registrar.anno;


import net.riking.imports.registrar.MapperScannerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 16:48
 */
@Import(MapperScannerRegistrar.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mapper {
	String[] value() default  "";
}
