package net.riking.web.config;

import net.riking.web.interceptor.SpringMVCInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 20:07
 */
@Configuration
@ComponentScan("net.riking.web")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//指定拦截器，指定拦截路径
		registry.addInterceptor(new SpringMVCInterceptor()).addPathPatterns("/*");
	}


	@Override
	/**
	 * 设置由 web 容器处理静态资源 ，相当于 xml中的<mvc:default-servlet-handler/>
	 */
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// 开启这个让 defaultServlet 先拦截，这个就不会进入 Spring 了，大概能提高性能吧
		//configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/template/**").addResourceLocations("/template/");

	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//super.configureMessageConverters(converters);

		// 消息转换器处理,AbstractMessageConverterMethodProcessor.writeWithMessageConverters
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		jsonConverter.setDefaultCharset(Charset.forName("UTF-8"));

		converters.add(jsonConverter);
	}

}
