package com.kadirtuna.issuemanagement.service;


import com.kadirtuna.issuemanagement.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IssueHistoryService {
  IssueHistory save(IssueHistory issue);

  IssueHistory getById(Long id);

  Page<IssueHistory> getAllPageable(Pageable pageable);

  Boolean delete(IssueHistory issueHistory);

}
