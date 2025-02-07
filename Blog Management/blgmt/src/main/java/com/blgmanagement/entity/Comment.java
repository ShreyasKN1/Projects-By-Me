package com.blgmanagement.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {
     @Id
     @GeneratedValue
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    public void setId(Long id) {
        this.id = id;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setPost(Post post) {
        this.post = post;
    }
    public Long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public Post getPost() {
        return post;
    }
    
}
