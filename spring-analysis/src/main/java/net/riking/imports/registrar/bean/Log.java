package net.riking.imports.registrar.bean;

/**
 * @Description 日志
 * @Author: kongLiuYi
 * @Date: 2020/2/23 16:51
 */
public class Log {
	public Log() {
		System.out.println("Log init...");
	}

	public void info(String msg){
		System.out.println(msg);
	}
}
