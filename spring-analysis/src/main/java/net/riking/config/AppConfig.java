package net.riking.config;

import net.riking.annotation.Mapper;
import net.riking.bean.Cat;
import net.riking.bean.Dog;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
	public String  catStringOne(){

		return "catStringOne";
	}

	@Bean
	public String  catStringTwo(){

		return "catStringTwo";
	}


	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}


}
