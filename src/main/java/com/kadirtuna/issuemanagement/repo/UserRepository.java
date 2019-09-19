package com.kadirtuna.issuemanagement.repo;

import com.kadirtuna.issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
