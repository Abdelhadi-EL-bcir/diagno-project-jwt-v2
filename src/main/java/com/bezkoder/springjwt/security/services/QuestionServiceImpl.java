package com.bezkoder.springjwt.security.services;


import com.bezkoder.springjwt.models.Category;
import com.bezkoder.springjwt.models.Question;
import com.bezkoder.springjwt.repository.CategoryRepository;
import com.bezkoder.springjwt.repository.QuestionRepository;
import com.bezkoder.springjwt.security.services.facades.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question update(Question question, Long id) {
        if(questionRepository.findById(id) != null){
            Question qstToUpdate = questionRepository.findQuestionById(id);
            qstToUpdate.setText(question.getText());
            questionRepository.save(qstToUpdate);
            return questionRepository.findQuestionById(qstToUpdate.getId());
        }else{
            return null;
        }
    }

    @Override
    public String delete(Long id) {
        questionRepository.deleteById(id);
        return "Question has deleted successfully";
    }

    @Override
    public Question get(Long id) {
        return questionRepository.findQuestionById(id);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getByCategory(Long id) {
        Category category = categoryRepository.findCategoryById(id);
        if(category != null){
             return  category.getQuestionList();
        }else{
            return  null;
        }
    }
}
