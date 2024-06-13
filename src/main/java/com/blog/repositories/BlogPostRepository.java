package com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost,Integer> {

}
