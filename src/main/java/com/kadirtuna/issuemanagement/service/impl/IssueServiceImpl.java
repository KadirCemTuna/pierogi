package com.kadirtuna.issuemanagement.service.impl;

import com.kadirtuna.issuemanagement.dto.IssueDto;
import com.kadirtuna.issuemanagement.entity.Issue;
import com.kadirtuna.issuemanagement.repository.IssueRepository;
import com.kadirtuna.issuemanagement.service.IssueService;
import com.kadirtuna.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

  private final IssueRepository issueRepository;
  private final ModelMapper modelMapper;

  public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {

    this.issueRepository = issueRepository;
    this.modelMapper = modelMapper;
  }


  @Override
  public IssueDto save(IssueDto issue) {
    if (issue.getDate() == null) { throw new IllegalArgumentException("Date cannot be null!");}
    Issue issueEntity= modelMapper.map(issue,Issue.class);
    issueEntity=issueRepository.save(issueEntity);
    issue.setId(issueEntity.getId());
    return issue;
  }

  @Override
  public IssueDto getById(Long id) {
   Issue i=issueRepository.getOne(id);
   return modelMapper.map(i,IssueDto.class);
  }

  @Override
  public TPage<IssueDto> getAllPageable(Pageable pageable) {
    Page<Issue> data=issueRepository.findAll(pageable);
    TPage page=new TPage<IssueDto>();
    IssueDto[] dtos=modelMapper.map(data.getContent(),IssueDto[].class);
    page.setStat(data, Arrays.asList(dtos));
    return page;
  }

  @Override
  public Boolean delete(Long issueID) {
      issueRepository.deleteById(issueID);
    return true;
  }

  @Override
  public IssueDto update(Long id, @Valid IssueDto issue) {
    Issue issueDB=issueRepository.getOne(id);
    if(issueDB==null) throw new IllegalArgumentException(id+" Issue Does Not Exist!");
    issueDB.setDescription(issue.getDescription());
    issueDB.setDetails(issue.getDetails());
    issueDB.setIssueStatus(issue.getIssueStatus());

    issueRepository.save(issueDB);
    return modelMapper.map(issueDB,IssueDto.class);
  }
}
