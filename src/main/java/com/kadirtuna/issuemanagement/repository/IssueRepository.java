package com.kadirtuna.issuemanagement.repository;

import com.kadirtuna.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {
}
