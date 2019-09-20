package com.kadirtuna.issuemanagement.repository;

import com.kadirtuna.issuemanagement.entity.Project;
import com.kadirtuna.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

  User getByUsername(String username);

  User findByUsername(String username);

  List<User> getByUsernameContains(String username);

  Page<User> findAll(Pageable pageable);

  List<User> findAll(Sort sort);


}
