package org.example.quoraspring.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CommentDTO {
    private Long id;
    private String comment;
    private Long answer_id;
    private Long parent_comment_id;
}
