package net.riking.web;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyGlobalExceptionHandler {


		/**
		 * 应用到所有被@RequestMapping注解的方法，在其执行之前初始化数据绑定器
		 * @param binder
		 */
		@InitBinder("a")
		public void globalInitBinder(WebDataBinder binder) {
			binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
			binder.setFieldDefaultPrefix("a.");
		}


	/**
	 * 数据绑定，使全局@RequestMapping可以获取到该值
	 * @return
	 */
	@ModelAttribute(name = "md")
	public Map<String,Object> mydata() {
		Map<String, Object> map = new HashMap<>();
		map.put("age", 99);
		map.put("gender", "男");
		return map;
	}

	/**
	 * 全局异常捕捉处理
	 * @param e
	 * @return
	 */
    @ExceptionHandler(Exception.class)
    public ModelAndView customException(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}