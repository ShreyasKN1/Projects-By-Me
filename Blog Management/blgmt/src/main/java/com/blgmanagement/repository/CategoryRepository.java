package com.blgmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blgmanagement.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}
