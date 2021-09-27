@EnableTransactionManagement
  @Import(TransactionManagementConfigurationSelector.class)

PROXY:

      1.AutoProxyRegistrar 
      
      2.ProxyTransactionManagementConfiguration
      
    TransactionInterceptor: 实现了 MethodInterceptor 接口，在这里定义了拦截行为。
    AnnotationTransactionAttributeSource：封装了目标方法是否被拦截的逻辑，虽然没有实现 Pointcut 接口，但是在后面目标方法判断的时候，实际上还是委托给了 AnnotationTransactionAttributeSource.getTransactionAttributeSource，通过适配器模式，返回了 Pointcut 切点信息。
    TransactionAttributeSourceAdvisor: 实现了 Advisor 接口，包装了上面两个信息。

  