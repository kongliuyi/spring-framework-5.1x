package net.riking.annotation;

import net.riking.config.MapperScannerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import(MapperScannerRegistrar.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mapper {
	String[] value() default  "";
}
