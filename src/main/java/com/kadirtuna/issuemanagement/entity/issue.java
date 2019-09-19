package com.kadirtuna.issuemanagement.entity;

import sun.util.resources.Bundles;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "issue")
public class issue extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "description",length = 400)
  private String description;

  @Column(name = "date")
  private Date date;

  @Enumerated(EnumType.STRING)
  private IssueStatus issueStatus;

}
