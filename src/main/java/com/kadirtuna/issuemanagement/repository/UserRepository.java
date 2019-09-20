package com.kadirtuna.issuemanagement.repository;

import com.kadirtuna.issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
