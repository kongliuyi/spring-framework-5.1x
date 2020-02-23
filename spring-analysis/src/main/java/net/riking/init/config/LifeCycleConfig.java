package net.riking.init.config;


import net.riking.init.bean.Pig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 14:13
 */
@Configuration
@ComponentScan("net.riking.init")
public class LifeCycleConfig {


	@Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
	public Pig pig(){
		return new Pig();
	}


}
