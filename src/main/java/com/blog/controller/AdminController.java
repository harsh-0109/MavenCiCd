package com.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entity.BlogPost;
import com.blog.exception.PostNotFoundException;
import com.blog.service.BlogPostServiceImpl;

@RestController
@RequestMapping("/post")
public class AdminController {
	
	private BlogPostServiceImpl service;
	
	public AdminController(BlogPostServiceImpl service)
	{
		this.service = service;
	}
	
	@PostMapping("/addPost")
	public String createPost(@RequestBody BlogPost post)
	{
		BlogPost createdPost = service.createPost(post);
		if(createdPost==null)
		{
			return "Something Went Wrong";
		}
		else {
			return "Post Created Successfully";
		}
	}
	
	@PutMapping("/update/{postId}")
	public String updatePost(@PathVariable int postId , @RequestBody BlogPost post)	
	{
		BlogPost updatedPost = service.updatePost(postId, post);
		return "Post updated successfully";
	}
	
	@DeleteMapping("delete/{postId}")
	public void deletePost(@PathVariable int postId) throws PostNotFoundException 
	{
		service.deletePost(postId);
	}
	
	@GetMapping("/getAll")
	public List<BlogPost> getAllPosts(@RequestParam(value = "pageNumber" , required = false)int pageNuber ,
			                          @RequestParam(value = "pageSize" , required = false)int pageSize)
	{
		List<BlogPost> allPosts = service.getAllPosts(pageNuber, pageSize);
		return allPosts;
	}
}
