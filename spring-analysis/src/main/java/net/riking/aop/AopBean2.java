package net.riking.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Stack;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 16:35
 */
@Component
public class AopBean2 {

	//@Autowired AopBean aopBean;

	public void testAop() {
		System.out.println("I am the true aop bean");
	}


	public static void main(String[] args) {
		String str = "1((331)[{}]())()(";
		System.out.println(match(str));
	}

	public static  boolean match(String str){
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char item=str.charAt(i);
			if(item=='('||item=='['||item=='{') {
				stack.push(item);
			}else if(item==')' ||item==']'||item=='}') {
				if(stack.isEmpty()) return  false;
					char top= stack.pop();
			if(!(( item==')' && top=='(' )||(item==']' && top=='[')||(item=='}' && top=='{'))){
				return  false;
				}
			}
		}
		return  stack.isEmpty();
	}
}
