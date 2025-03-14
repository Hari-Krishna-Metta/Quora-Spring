package org.example.quoraspring.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private Date created_at;
    private Long user_id;
}
