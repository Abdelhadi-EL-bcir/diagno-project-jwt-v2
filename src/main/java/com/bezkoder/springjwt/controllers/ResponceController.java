package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.Responce;
import com.bezkoder.springjwt.security.services.ResponceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/res")
public class ResponceController {

    @Autowired
    private ResponceServiceImpl responceServiceImpl;

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Responce create(@RequestBody Responce responce) {
        return responceServiceImpl.create(responce);
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Responce update(@RequestBody Responce responce,@PathVariable Long id) {
        return responceServiceImpl.update(responce, id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String delete(@PathVariable Long id) {
        return responceServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Responce get(@PathVariable  Long id) {
        return responceServiceImpl.get(id);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Responce> getAll() {
        return responceServiceImpl.getAll();
    }
}
