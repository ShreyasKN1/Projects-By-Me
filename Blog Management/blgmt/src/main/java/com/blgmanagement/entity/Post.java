package com.blgmanagement.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="posts")
public class Post {
    @Id 
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name="author_id")
    private User author;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
}
