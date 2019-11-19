package net.riking.config;

import net.riking.annotation.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("net.riking")
@Conditional(MyConditional.class)
@Mapper
@Import(MyImportSelector.class)
public class AppConfig {


}
