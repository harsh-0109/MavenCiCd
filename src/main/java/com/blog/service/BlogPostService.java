package com.blog.service;

import java.util.List;

import com.blog.entity.BlogPost;
import com.blog.exception.PostNotFoundException;

public interface BlogPostService {
	
	BlogPost createPost(BlogPost post);
	
	BlogPost updatePost(int postId , BlogPost post);
	
    void deletePost(int postId) throws PostNotFoundException;
    
    List<BlogPost> getAllPosts(int pageNumber , int pageSize);

}
