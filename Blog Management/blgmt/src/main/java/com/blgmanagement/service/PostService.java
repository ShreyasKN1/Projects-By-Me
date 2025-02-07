package com.blgmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blgmanagement.entity.Post;
import com.blgmanagement.repository.PostRepository;

@Service
public class PostService {
     @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> getPostsByAuthorId(Long authorId) {
        return postRepository.findByAuthorId(authorId);
    }

    public List<Post> getPostsByCategoryId(Long categoryId) {
        return postRepository.findByCategoryId(categoryId);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
    
}
