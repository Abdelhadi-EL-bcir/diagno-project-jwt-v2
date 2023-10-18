package com.bezkoder.springjwt.security.services.facades;


import com.bezkoder.springjwt.models.Category;

import java.util.List;

public interface CategoryService {
    public Category create(Category category);
    public Category update(Category category , Long id);
    public String delete(Long id);
    public Category get(Long id);
    public List<Category> getAll();
}
