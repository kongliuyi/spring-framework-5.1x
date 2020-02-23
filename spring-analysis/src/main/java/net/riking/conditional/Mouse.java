package net.riking.conditional;


import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 16:21
 */
@Conditional(MyConditional.class)
@Component
public class Mouse {
	public  Mouse() {
		System.out.println("Mouse init...");
	}
}
