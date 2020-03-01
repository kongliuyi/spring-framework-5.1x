package net.riking.web.initializer;

import net.riking.web.config.WebConfig;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Description 仿造 SpringServletContainerInitializer
 * @Author: kongLiuYi
 * @Date: 2020/2/28 15:24
 */
@HandlesTypes(MyWebApplicationInitializer.class)
public class MySpringServletContainerInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> webAppInitializerClasses, ServletContext servletContext) throws ServletException {
		System.out.println("MySpringServletContainerInitializer...");
		List<MyWebApplicationInitializer> initializers = new LinkedList<>();

		if (webAppInitializerClasses != null) {
			for (Class<?> waiClass : webAppInitializerClasses) {

				if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) &&
						MyWebApplicationInitializer.class.isAssignableFrom(waiClass)) {
					try {
						initializers.add((MyWebApplicationInitializer)
								ReflectionUtils.accessibleConstructor(waiClass).newInstance());
					}
					catch (Throwable ex) {
						throw new ServletException("Failed to instantiate WebApplicationInitializer class", ex);
					}
				}
			}
		}

		if (initializers.isEmpty()) {
			servletContext.log("No Spring WebApplicationInitializer types detected on classpath");
			return;
		}

		servletContext.log(initializers.size() + " Spring WebApplicationInitializers detected on classpath");
		AnnotationAwareOrderComparator.sort(initializers);
		for (MyWebApplicationInitializer initializer : initializers) {
			initializer.onStartup(servletContext);
		}
	}
}
