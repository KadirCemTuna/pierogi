package com.kadirtuna.issuemanagement.api;


import com.kadirtuna.issuemanagement.dto.IssueDto;
import com.kadirtuna.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

  private final com.kadirtuna.issuemanagement.service.impl.IssueServiceImpl IssueServiceImpl;

  public IssueController(com.kadirtuna.issuemanagement.service.impl.IssueServiceImpl issueServiceImpl) {
    IssueServiceImpl = issueServiceImpl;
  }

  @GetMapping("/{id}")
  public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
    IssueDto p = IssueServiceImpl.getById(id);

    return ResponseEntity.ok(p);
  }

  @PostMapping("/send")
  public ResponseEntity<IssueDto> createPost(@Valid @RequestBody IssueDto issueDto) {
    return ResponseEntity.ok(IssueServiceImpl.save(issueDto));
  }
//PUT for updates

  @PutMapping("/{id}")
  public ResponseEntity<IssueDto> updateProject(@Valid @RequestBody IssueDto issueDto, @PathVariable(value = "id",required = true)  Long id ) {
    return ResponseEntity.ok(IssueServiceImpl.update(id, issueDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> deleteProject( @PathVariable(value = "id",required = true) Long id){
    return ResponseEntity.ok(IssueServiceImpl.delete(id));
  }
}
