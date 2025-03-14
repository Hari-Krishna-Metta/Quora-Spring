package org.example.quoraspring.services;

import org.example.quoraspring.dtos.CommentDTO;
import org.example.quoraspring.models.Answer;
import org.example.quoraspring.models.Comment;
import org.example.quoraspring.repositories.AnswerRepository;
import org.example.quoraspring.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private AnswerRepository answerRepository;

    public List<Comment> getCommentByAnswerId(Long answerId) {
        return commentRepository.findCommentByAnswer_Id(answerId);
    }

    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> getRepliesByCommentId(Long commentId) {
        return commentRepository.findCommentByParentCommentId(commentId);
    }

    public Comment createComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setComment(commentDTO.getComment());

        Optional<Answer> answer = answerRepository.findById(commentDTO.getAnswer_id());
        if (answer.isPresent()) {
            comment.setAnswer(answer.get());
        }

        if(commentDTO.getParent_comment_id() != null) {
            Optional<Comment> parent = commentRepository.findById(commentDTO.getParent_comment_id());
            if(parent.isPresent()) {
                comment.setParentComment(parent.get());
            }
        }
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
