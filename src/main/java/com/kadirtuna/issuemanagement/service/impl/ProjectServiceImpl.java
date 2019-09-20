package com.kadirtuna.issuemanagement.service.impl;

import com.kadirtuna.issuemanagement.entity.Project;
import com.kadirtuna.issuemanagement.repository.ProjectRepository;
import com.kadirtuna.issuemanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

  private final ProjectRepository projectRepository;
  public ProjectServiceImpl(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @Override
  public Project save(Project project) {
    if (project.getProjectCode() == null) throw new IllegalArgumentException("Project Code Can not be null!!");

      return projectRepository.save(project);
  }

  @Override
  public Project getById(Long id) {
    return projectRepository.getOne(id);
  }

  @Override
  public List<Project> getByProjectCode(String projectCode) {
    return projectRepository.getByProjectCode(projectCode);
  }

  @Override
  public List<Project> getByProjectCodeContains(String projectCode) {
    return projectRepository.getByProjectCodeContains(projectCode);
  }

  @Override
  public Page<Project> getAllPageable(Pageable pageable) {
    return projectRepository.findAll(pageable);
  }

  @Override
  public Boolean delete(Project project) {
    projectRepository.delete(project);
    return Boolean.TRUE;
  }
}
