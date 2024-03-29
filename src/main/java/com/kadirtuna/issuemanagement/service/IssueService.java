package com.kadirtuna.issuemanagement.service;

import com.kadirtuna.issuemanagement.dto.IssueDto;
import com.kadirtuna.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;


public interface IssueService {
  IssueDto save(IssueDto issue);

  IssueDto getById(Long id);

  TPage<IssueDto> getAllPageable(Pageable pageable);

  Boolean delete(Long IssueID);

  IssueDto update(Long id, IssueDto project);
}
