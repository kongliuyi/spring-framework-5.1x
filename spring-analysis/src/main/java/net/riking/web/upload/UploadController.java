package net.riking.web.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 文件上传分析,请使用 postman 测试
 * @Author: kongLiuYi
 * @Date: 2020/5/17 0017 17:58
 */
@Controller
@RequestMapping("/upload")
public class UploadController {


	@PostMapping("/picture")
	@ResponseBody
	public Map<String, String> uploadPicture(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("[文件类型] - [{}]" + file.getContentType());
		System.out.println("[文件名称] - [{}]" + file.getOriginalFilename());
		System.out.println("[文件大小] - [{}]" + file.getSize());
		//保存
		file.transferTo(new File("E:\\图片\\" + file.getOriginalFilename()));
		Map<String, String> result = new HashMap<>(16);
		result.put("contentType", file.getContentType());
		result.put("fileName", file.getOriginalFilename());
		result.put("fileSize", file.getSize() + "");
		return result;
	}


	/**
	 * 带参数上传文件
	 *
	 * @param file 文件
	 * @param name 参数姓名
	 * @param request 参数年龄
	 * @return result
	 */
	@PostMapping("/picture/param")
	@ResponseBody
	public Map<String, String> uploadPictureParam(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, HttpServletRequest request) throws IOException {
		String age = request.getParameter("age");
		System.out.println("[参数姓名] " + name);
		System.out.println("[参数年龄] " + age);
		//保存
		file.transferTo(new File("E:\\图片\\" + file.getOriginalFilename()));
		Map<String, String> result = new HashMap<>(16);
		result.put("name", name);
		result.put("age", age);
		return result;
	}

}
