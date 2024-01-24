package com.example.TodoApp.repository;

import com.example.TodoApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<Account> findByName();
}
