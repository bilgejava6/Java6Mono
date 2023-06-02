package com.muhammet.Java6Mono.repository;

import com.muhammet.Java6Mono.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository  extends JpaRepository<User,Long> {

    User findByUsername(String username);

    User findByEmail(String email);

    Optional<User> findOptionalByUsernameAndPassword(String username, String password);

    User findByEmailAndPassword(String email,String password);
}
