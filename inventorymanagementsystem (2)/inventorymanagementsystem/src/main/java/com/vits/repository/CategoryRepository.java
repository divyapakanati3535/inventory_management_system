package com.vits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vits.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
