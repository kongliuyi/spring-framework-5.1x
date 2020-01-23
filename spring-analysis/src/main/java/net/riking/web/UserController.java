package net.riking.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {

	@GetMapping("login")
	@ResponseBody
	public  String login(){
		return "succeed";
	}

	@RequestMapping(value = "plain")
	@ResponseBody
	public String plain(@PathVariable String name) {
		return name;
	}


	@GetMapping("/hello")
	public String hello(Model model) {
		Map<String, Object> map = model.asMap();
		System.out.println(map);
		int i = 1 / 0;
		return "hello controller advice";
	}


	@GetMapping("/index1")
	public Object index(ModelMap modelMap) {
		System.out.println(modelMap.get("md"));
		return modelMap.get("md");
	}

	// 也可以通过@ModelAttribute获取
	@GetMapping("/index2")
	public String index(@ModelAttribute("md") Map<String, Object> md ) {
		System.out.println(md.get("gender"));
		return md.get("gender").toString();
	}
}
