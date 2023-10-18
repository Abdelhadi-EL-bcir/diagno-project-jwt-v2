package com.bezkoder.springjwt.security.services.facades;



import com.bezkoder.springjwt.models.Question;

import java.util.List;

public interface QuestionService {
    public Question create(Question question);
    public Question update(Question question , Long id);
    public String delete(Long id);
    public Question get(Long id);
    public List<Question> getAll();
    public List<Question> getByCategory(Long id);
}
