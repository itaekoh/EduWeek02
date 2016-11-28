package com.edu.week01.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.week01.model.User;

@Controller
public class UserController {
	
	/* 
	 * 1. 클라이언트에서 요청온 내용을 확인해 보기위한 간단 예,
	 *    아래처럼 method의 인자로 받을 수 있다.
	 *    public String create(String userId, String password, String name, String email) { 
	 *    인자값이 많아지면 길어 지겠죠??
	 */
	/*
	@PostMapping("/user/create")
	public String create(String userId, String name, String password, String email) {
		System.out.println("userId = " + userId +", name = " + name + ", email = " + email);
		return "";
	}
	*/
	
	/*
	 * 2. 위 처럼, Method의 인자가 많아지면 너무 길어져 가독성이 떨어지므로,
	 *    새로운 User.class DAO를 만들고 요청을 해당 DAO에 기록한다.
	 *    이때, 요청의 인자값을 getter/setter값으로 동일하게 매칭시켜야 한다. 
	 *    >> name -> setName, email -> setEmail.....그럼, 자동으로 매칭이 된다.
	 */
	List<User> users = new ArrayList<>(); //여러 데이터를 등록할 List콜렉션 생성.
	
	@PostMapping("/user/create")
	public String create(User user) { //넘어온 인자를 바로 User로 받는다.
		users.add(user); //User객체를 users라는 ArrayList<User>에 담는다.
		System.out.println("결과가 제대로 들어갔는지.. users : " + users);  //users를 찍으려면 User에 toString()이 overriding될것.
		return "redirect:/users"; //template이 아닌, 결과를 넘겨줄 url
	}
	
	@GetMapping("/users") //입력하고 넘어온 url을 받아서 목록페이지를 구현한다.
	public String list(Model model) {
		model.addAttribute("users", users); //Model객체에 담아서 클라이언트로 보낸다.
		return "/user/list";  //회원목록이 보여질 template.
	}
	
	@GetMapping("/user/form")
	public String form() {
		return "/user/form";
	}
}
