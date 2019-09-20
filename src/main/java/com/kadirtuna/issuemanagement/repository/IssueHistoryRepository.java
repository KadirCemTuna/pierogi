package com.kadirtuna.issuemanagement.repository;

import com.kadirtuna.issuemanagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {

  List<IssueHistory> getByIssueIdOrderById(Long id);


}
