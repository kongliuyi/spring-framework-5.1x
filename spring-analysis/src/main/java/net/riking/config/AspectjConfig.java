package net.riking.config;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
@EnableAsync
public class AspectjConfig {



}
