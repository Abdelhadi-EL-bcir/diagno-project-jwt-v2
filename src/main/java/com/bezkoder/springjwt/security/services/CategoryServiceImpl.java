package com.bezkoder.springjwt.security.services;


import com.bezkoder.springjwt.models.Category;
import com.bezkoder.springjwt.repository.CategoryRepository;
import com.bezkoder.springjwt.security.services.facades.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category, Long id) {
        if(categoryRepository.findById(id) != null){
            Category categoryToUpdate = categoryRepository.findCategoryById(id);
            categoryToUpdate.setName(category.getName());
            return categoryRepository.findCategoryById(categoryToUpdate.getId());
        }else{
            return  null;
        }
    }

    @Override
    public String delete(Long id) {
        categoryRepository.deleteById(id);
        return "User has deleted successfully";
    }

    @Override
    public Category get(Long id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

}
