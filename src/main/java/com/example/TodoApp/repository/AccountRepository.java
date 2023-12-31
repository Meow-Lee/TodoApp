package com.example.TodoApp.repository;

import com.example.TodoApp.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
//    Optional<Account> findByName();
}
