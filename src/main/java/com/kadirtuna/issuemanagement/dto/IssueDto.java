package com.kadirtuna.issuemanagement.dto;

import com.kadirtuna.issuemanagement.entity.IssueStatus;
import io.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="Issue Data Transfer Object")
public class IssueDto {
  @ApiModelProperty(required = true,value = "Issue ID")
  private Long id;
  @ApiModelProperty(required = true,value = "Issue Description")
  private String description;
  @ApiModelProperty(required = true,value = "Issue Details")
  private String details;
  @ApiModelProperty(required = true,value = "Issue Creation Date")
  private Date date;
  @ApiModelProperty(required = true,value = "Issue Status")
  @NotNull
  private IssueStatus issueStatus;
  @ApiModelProperty(required = true,value = "Issue Assignee")
  private UserDto assignee;
  @ApiModelProperty(required = true,value = "Issue Project")
  private ProjectDto project;
}
