package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
   public Question findQuestionById(Long id);
}
