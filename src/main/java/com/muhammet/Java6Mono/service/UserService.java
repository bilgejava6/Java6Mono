package com.muhammet.Java6Mono.service;

import com.muhammet.Java6Mono.repository.IUserRepository;
import com.muhammet.Java6Mono.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository repository;

    public void save(String username,String email,String password){
        repository.save(com.muhammet.Java6Mono.repository.entity.User.builder()
                .username(username)
                .email(email)
                .password(password)
                .build());
    }

    public boolean isUser(String username,String password){
        Optional<User> user = repository.findOptionalByUsernameAndPassword(username, password);
        return user.isPresent();
    }


}
