package com.edu.week01.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.week01.model.Post;

@Controller
public class PostController {
	List<Post> posts = new ArrayList<>();
	
	@PostMapping("/qna/create")
	public String create(Post post) {
		posts.add(post);
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("posts", posts);
		return "/index";
	}
	
	@GetMapping("/qna/form")
	public String form() {
		return "/qna/form";
	}
}
