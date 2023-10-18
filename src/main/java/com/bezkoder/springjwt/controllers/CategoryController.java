package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.Category;
import com.bezkoder.springjwt.security.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cat")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Category create(@RequestBody Category category) {
        return categoryServiceImpl.create(category);
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Category update(@RequestBody Category category,@PathVariable Long id) {
        return categoryServiceImpl.update(category, id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String delete(@PathVariable Long id) {
        return categoryServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Category get(@PathVariable Long id) {
        return categoryServiceImpl.get(id);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Category> getAll() {
        return categoryServiceImpl.getAll();
    }
    
}
