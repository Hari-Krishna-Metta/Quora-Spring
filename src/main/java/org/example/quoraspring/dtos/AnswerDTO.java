package org.example.quoraspring.dtos;

import lombok.Data;

@Data
public class AnswerDTO {
    private Long id;
    private String content;
    private Long questionId;
    private Long userId;
}
