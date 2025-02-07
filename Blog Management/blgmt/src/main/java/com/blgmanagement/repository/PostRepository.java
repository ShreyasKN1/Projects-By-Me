package com.blgmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blgmanagement.entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long>{
    List<Post> findByAuthorId(Long authorId);
    List<Post> findByCategoryId(Long categoryId);
}