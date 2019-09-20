package com.kadirtuna.issuemanagement.repository;

import com.kadirtuna.issuemanagement.entity.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {



  Page<Issue> findAll(Pageable pageable);

  List<Issue> findAll(Sort sort);
}
