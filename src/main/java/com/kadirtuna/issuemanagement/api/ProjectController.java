package com.kadirtuna.issuemanagement.api;


import com.kadirtuna.issuemanagement.dto.ProjectDto;


import com.kadirtuna.issuemanagement.service.impl.ProjectServiceImpl;
import com.kadirtuna.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
public class ProjectController {

  private final ProjectServiceImpl projectServiceImpl;

  public ProjectController(ProjectServiceImpl projectServiceImpl) {
    this.projectServiceImpl = projectServiceImpl;
  }

  /*
      Http metotları

      GET
      POST
      PUT
      DELETE
   */
  @GetMapping("/{id}")
  public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
    ProjectDto p = projectServiceImpl.getById(id);

    return ResponseEntity.ok(p);
  }

  @PostMapping("/send")
  public ResponseEntity<ProjectDto> createIssue(@Valid @RequestBody ProjectDto project) {
    return ResponseEntity.ok(projectServiceImpl.save(project));
  }
//PUT for updates

  @PutMapping("/{id}")
  public ResponseEntity<ProjectDto> updateIssue(@Valid @RequestBody ProjectDto projectDto, @PathVariable(value = "id",required = true)  Long id ) {
    return ResponseEntity.ok(projectServiceImpl.update(id, projectDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> deleteIssue( @PathVariable(value = "id",required = true) Long id){
    return ResponseEntity.ok(projectServiceImpl.delete(id));
  }
}
