package com.kadirtuna.issuemanagement.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Project extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "project_code",unique = true)
  private String projectCode;

  @Column(name = "project_name")
  private String projectName;

}