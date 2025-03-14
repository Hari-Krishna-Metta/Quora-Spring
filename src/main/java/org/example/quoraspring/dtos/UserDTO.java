package org.example.quoraspring.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
}
