package net.riking.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description 拦截器
 * @Author: kongLiuYi
 * @Date: 2019/11/22 13:35
 */
public class SpringMVCInterceptor implements HandlerInterceptor {


	/**
	 * preHandle 方法是进行处理器拦截用的，顾名思义，该方法将在 Controller 处理之前进行调用
	 * <p>
	 * 源码路径：DispatcherServlet.doDispatch
	 * mappedHandler.applyPreHandle(processedRequest, response)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		request.getSession().setAttribute("username", "sss");
		return true;
	}

	/**
	 * postHandle 是进行处理器拦截用的，它的执行时间是在处理器进行处理之
	 * 后，也就是在Controller的方法调用之后执行，但是它会在 DispatcherServlet 进行视图的渲染之前执行，
	 * 也就是说在这个方法中你可以对 ModelAndView 进行操作。
	 * 源码路径：DispatcherServlet.doDispatch
	 * mappedHandler.applyPostHandle(processedRequest, response, mv);
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		System.out.println("拦截器");
		System.out.println(request.getSession().getAttribute("username"));
		//if(modelAndView == null){
		modelAndView = new ModelAndView();
		//}
		modelAndView.addObject("user", "sss");

	}

	/**
	 * 该方法将在整个请求完成之后，也就是 DispatcherServlet 渲染了视图执行，这个方法的主要作用是用于清理资源的.
	 * 源码路径：正常情况 DispatcherServlet.doDispatch
	 * processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException)
	 * mappedHandler.triggerAfterCompletion(request, response, null);
	 * 异常情况 DispatcherServlet.doDispatch
	 * triggerAfterCompletion(processedRequest, response, mappedHandler,
	 * new NestedServletException("Handler processing failed", err));
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		System.out.println("110");

	}

}