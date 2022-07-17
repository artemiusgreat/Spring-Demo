package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.company.model.User;

@Component
public interface UserRepository extends JpaRepository<User, Long>{
}
