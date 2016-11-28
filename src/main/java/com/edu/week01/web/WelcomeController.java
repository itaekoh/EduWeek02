package com.edu.week01.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //controller임을 명시.
public class WelcomeController {
	
	/**
	 * MVC를 이해하기 위한 최초 예제..
	 * @param name
	 * @param age
	 * @param model
	 * @return
	 * ==================================
	 * 요청 -> http://localhost:8080/hello?name=itaek&age=30
	 * template를 통한 결과 -> itaek, Hello~. my age is 30
	 */
	@GetMapping("/hello") //URL매핑.
	public String welcome(String name, int age, Model model) {
		System.out.println("name :" + name + ", age : " + age); //front에서 넘어온 값을 체크한다.
		
		//front에 값을 model에 담아 전달한다.
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "welcome"; //template<html>으로 넘김.
	}
	
}
