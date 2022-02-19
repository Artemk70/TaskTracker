package com.taskTracker.controller;

import com.taskTracker.api.request.RequestProject;
import com.taskTracker.model.Project;
import com.taskTracker.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@Tag(name = "Project controller")
public class ProjectController {

    private final ProjectService projectService;

    @Operation(summary = "create project")
    @PostMapping("/project/create")
    public ResponseEntity<?> create(@RequestBody RequestProject requestProject) {
        return new ResponseEntity<>(projectService.create(requestProject), HttpStatus.OK);
    }

    @Operation(summary = "view project")
    @GetMapping("/project/{id}")
    public ResponseEntity<Project> view(@PathVariable long id) {
        return new ResponseEntity<>(projectService.view(id), HttpStatus.OK);
    }

    @Operation(summary = "update project")
    @PostMapping("/project/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody RequestProject requestProject) {
        return new ResponseEntity<>(projectService.update(id, requestProject), HttpStatus.OK);
    }

    @Operation(summary = "delete project")
    @DeleteMapping("/project/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return new ResponseEntity<>(projectService.delete(id), HttpStatus.OK);
    }

}
