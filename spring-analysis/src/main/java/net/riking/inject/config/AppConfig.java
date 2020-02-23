package net.riking.inject.config;


import net.riking.inject.bean.Dog;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 14:13
 */
@Configuration
@ComponentScan("net.riking.inject")
public class AppConfig {

	@Bean
	public Dog dogBean(){

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
