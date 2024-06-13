package com.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entity.BlogPost;
import com.blog.service.BlogPostServiceImpl;

@RestController
@RequestMapping("/reader")
public class ReaderController {
	
private BlogPostServiceImpl service;
	
	public ReaderController(BlogPostServiceImpl service)
	{
		this.service = service;
	}
	
	@GetMapping("/getAll")
	public List<BlogPost> getAllPosts(@RequestParam(value = "pageNumber" , required = false)int pageNuber ,
			                          @RequestParam(value = "pageSize" , required = false)int pageSize)
	{
		List<BlogPost> allPosts = service.getAllPosts(pageNuber, pageSize);
		return allPosts;
	}

}
