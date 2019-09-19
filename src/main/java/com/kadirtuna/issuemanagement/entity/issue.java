package com.kadirtuna.issuemanagement.entity;

import java.util.Date;

public class issue extends BaseEntity {
  private Long id;
  private String description;
  private Date date;
  private IssueStatus issueStatus;

}
