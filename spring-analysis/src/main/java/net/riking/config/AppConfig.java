package net.riking.config;

import net.riking.annotation.Mapper;
import net.riking.bean.Dog;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("net.riking")
@Conditional(MyConditional.class)
@Mapper
@Import(MyImportSelector.class)
public class AppConfig {

	@Bean
	public Dog  dogBean(){

		return new Dog();
	}

	@Bean
	public String  dogString(){
		dogBean();
		return "xxxx";
	}

}
