package com.example.sign_up_validation.repository;

import com.example.sign_up_validation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
