package com.kadirtuna.issuemanagement.api;


import com.kadirtuna.issuemanagement.dto.IssueDto;
import com.kadirtuna.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value = "Issue APIs")
public class IssueController {

  private final com.kadirtuna.issuemanagement.service.impl.IssueServiceImpl IssueServiceImpl;

  public IssueController(com.kadirtuna.issuemanagement.service.impl.IssueServiceImpl issueServiceImpl) {
    IssueServiceImpl = issueServiceImpl;
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Get Issue By Id Operation",response = IssueDto.class)
  public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
    IssueDto p = IssueServiceImpl.getById(id);

    return ResponseEntity.ok(p);
  }

  @PostMapping("/send")
  @ApiOperation(value = "Create Issue Operation",response = IssueDto.class)
  public ResponseEntity<IssueDto> createPost(@Valid @RequestBody IssueDto issueDto) {
    return ResponseEntity.ok(IssueServiceImpl.save(issueDto));
  }
//PUT for updates

  @PutMapping("/{id}")
  @ApiOperation(value = "Update Issue Operation",response = IssueDto.class)
  public ResponseEntity<IssueDto> updateProject(@Valid @RequestBody IssueDto issueDto, @PathVariable(value = "id",required = true)  Long id ) {
    return ResponseEntity.ok(IssueServiceImpl.update(id, issueDto));
  }

  @DeleteMapping("/{id}")
  @ApiOperation(value = "Delete Issue Operation",response = Boolean.class)
  public ResponseEntity<Boolean> deleteProject( @PathVariable(value = "id",required = true) Long id){
    return ResponseEntity.ok(IssueServiceImpl.delete(id));
  }
}
