package com.bezkoder.springjwt.controllers;



import com.bezkoder.springjwt.models.Question;
import com.bezkoder.springjwt.security.services.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/qst")
public class QuestionController {

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Question create(@RequestBody  Question question) {
        return questionServiceImpl.create(question);
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Question update(@RequestBody Question question,@PathVariable Long id) {
        return questionServiceImpl.update(question, id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String delete(@PathVariable  Long id) {
        return questionServiceImpl.delete(id);
    }


    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Question get(@PathVariable Long id) {
        return questionServiceImpl.get(id);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Question> getAll() {
        return questionServiceImpl.getAll();
    }

    @GetMapping("/cat/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Question> getByCategory(@PathVariable  Long id) {
        return questionServiceImpl.getByCategory(id);
    }

    @Autowired
    private QuestionServiceImpl questionServiceImpl;

}
