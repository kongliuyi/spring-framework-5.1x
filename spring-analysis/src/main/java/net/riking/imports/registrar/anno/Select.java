package net.riking.imports.registrar.anno;

import java.lang.annotation.*;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 16:48
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {
	String[] value() default  "";
}
