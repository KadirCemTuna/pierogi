package com.kadirtuna.issuemanagement.dto;

import com.kadirtuna.issuemanagement.entity.IssueStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class IssueDto {
  private Long id;
  private String description;
  private String details;
  private Date date;
  @NotNull
  private IssueStatus issueStatus;
  private UserDto assignee;
  private ProjectDto project;
}
