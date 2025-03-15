package org.example.quoraspring.services;

import org.example.quoraspring.models.User;
import org.example.quoraspring.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User signUpUser(User user) {
        User signup = new User();
        signup.setUsername(user.getUsername());
        signup.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        signup.setEmail(user.getEmail());
        return authRepository.save(signup);
    }
}
