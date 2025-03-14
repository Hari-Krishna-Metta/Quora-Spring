package org.example.quoraspring.services;

import org.example.quoraspring.dtos.QuestionDTO;
import org.example.quoraspring.models.Question;
import org.example.quoraspring.models.User;
import org.example.quoraspring.repositories.QuestionRepository;
import org.example.quoraspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(long id) {
        return questionRepository.findById(id);
    }

    public Question createQuestion(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setTitle(questionDTO.getTitle());
        question.setCreated_at(questionDTO.getCreated_at());
        question.setDescription(questionDTO.getDescription());

        Optional<User> user = userRepository.findById(questionDTO.getUser_id());
        if(user.isPresent()) {
            question.setUser(user.get());
        }
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public Optional<List<Question>> getQuestionsByUser(Long id) {
        Optional<List<Question>> lt =  questionRepository.getQuestionsByUser_Id(id);
        if(lt.isPresent()) {
            return lt;
        }
        return Optional.empty();
    }
}
