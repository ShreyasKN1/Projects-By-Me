package com.blgmanagement.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="categories")
public class Category {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Post> posts;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Post> getPosts() {
        return posts;
    }
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", posts=" + posts + "]";
    }
    
   
}
