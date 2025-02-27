package com.example.Spring_PayRoll_App.repository;

import com.example.Spring_PayRoll_App.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
