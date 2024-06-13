package com.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blog.entity.BlogPost;
import com.blog.exception.PostNotFoundException;
import com.blog.repositories.BlogPostRepository;

@Service
public class BlogPostServiceImpl implements BlogPostService{
	
	private BlogPostRepository blogRepo;
	
	public BlogPostServiceImpl(BlogPostRepository blogPostRepository)
	{
		this.blogRepo = blogPostRepository;
	}

	@Override
	public BlogPost createPost(BlogPost post) {
		BlogPost blogPost = blogRepo.save(post);
		return blogPost;
	}

	@Override
	public BlogPost updatePost(int postId , BlogPost post) {
		BlogPost blogPost = blogRepo.findById(postId).get();
			blogPost.setTitle(post.getTitle());
			blogPost.setContent(post.getContent());
			blogRepo.save(blogPost);
		return blogPost;
	}

	@Override
	public void deletePost(int postId) throws PostNotFoundException {
		BlogPost post = blogRepo.findById(postId).orElseThrow(() -> 
		new PostNotFoundException("Post not found for Id"+postId));
		blogRepo.delete(post);
	}

	@Override
	public List<BlogPost> getAllPosts(int pageNumber , int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<BlogPost> posts = blogRepo.findAll(pageable);
		List<BlogPost> postList = posts.getContent();
		return postList; 
	}

}
