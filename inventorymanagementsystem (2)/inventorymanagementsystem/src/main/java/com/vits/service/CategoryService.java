package com.vits.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vits.entity.Category;
import com.vits.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            updatedCategory.setId(id); // Make sure you have a setId method in your Supplier entity
            return categoryRepository.save(updatedCategory);
        } else {
            return null;
        }
    }

    public boolean deleteCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id); // Correct the variable name here
        if (category.isPresent()) {
        	categoryRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
