package org.example.quoraspring.repositories;

import org.example.quoraspring.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    public Optional<List<Question>> getQuestionsByUser_Id(Long id);
}

