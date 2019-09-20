package com.kadirtuna.issuemanagement.repository;

import com.kadirtuna.issuemanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

  List<Project> getAllByProjectCode(String projectCode);
}
