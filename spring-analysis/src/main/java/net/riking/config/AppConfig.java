package net.riking.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;

@ComponentScan("nei.riking")
@Conditional(MyConditional.class)
public class AppConfig {


}
