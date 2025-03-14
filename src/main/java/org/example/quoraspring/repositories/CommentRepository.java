package org.example.quoraspring.repositories;

import org.example.quoraspring.dtos.CommentDTO;
import org.example.quoraspring.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findCommentByAnswer_Id(Long answer_id);
    public List<Comment> findCommentByParentCommentId(Long parentCommentId);
}
