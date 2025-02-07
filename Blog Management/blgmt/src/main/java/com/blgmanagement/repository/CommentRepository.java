package com.blgmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blgmanagement.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}