package com.kadirtuna.issuemanagement.api;


import com.kadirtuna.issuemanagement.dto.ProjectDto;


import com.kadirtuna.issuemanagement.service.impl.ProjectServiceImpl;
import com.kadirtuna.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = ApiPaths.ProjectCtrl.CTRL)
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
  @ApiOperation(value = "Get Project By Id Operation",response = ProjectDto.class)
  public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
    ProjectDto p = projectServiceImpl.getById(id);

    return ResponseEntity.ok(p);
  }

  @PostMapping("/send")
  @ApiOperation(value = "Create Project Operation",response = ProjectDto.class)
  public ResponseEntity<ProjectDto> createIssue(@Valid @RequestBody ProjectDto project) {
    return ResponseEntity.ok(projectServiceImpl.save(project));
  }
//PUT for updates

  @PutMapping("/{id}")
  @ApiOperation(value = "Update Project Operation",response = ProjectDto.class)
  public ResponseEntity<ProjectDto> updateIssue(@Valid @RequestBody ProjectDto projectDto, @PathVariable(value = "id",required = true)  Long id ) {
    return ResponseEntity.ok(projectServiceImpl.update(id, projectDto));
  }

  @DeleteMapping("/{id}")
  @ApiOperation(value = "Delete Project Operation",response = Boolean.class)
  public ResponseEntity<Boolean> deleteIssue( @PathVariable(value = "id",required = true) Long id){
    return ResponseEntity.ok(projectServiceImpl.delete(id));
  }
}
