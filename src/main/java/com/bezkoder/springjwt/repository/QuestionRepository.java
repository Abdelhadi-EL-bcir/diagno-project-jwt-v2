package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Category;
import com.bezkoder.springjwt.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
   public Question findQuestionById(Long id);
}
