package com.blog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entity.BlogPost;
import com.blog.exception.PostNotFoundException;
import com.blog.service.BlogPostServiceImpl;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
private BlogPostServiceImpl service;
	
	public AuthorController(BlogPostServiceImpl service)
	{
		this.service = service;
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

}
