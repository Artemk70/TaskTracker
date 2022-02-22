package com.taskTracker.controller;

import com.taskTracker.api.request.RequestTask;
import com.taskTracker.model.Task;
import com.taskTracker.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@Tag(name = "Task controller ")
public class TaskController {

    private final TaskService taskService;

    @Operation(summary = "create task")
    @PostMapping("/tasks")
    public ResponseEntity<?> create(@RequestBody RequestTask requestTask) {
        return new ResponseEntity<>(taskService.create(requestTask), HttpStatus.OK);
    }

    @Operation(summary = "view task")
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> view(@PathVariable long id) {
        return new ResponseEntity<>(taskService.view(id), HttpStatus.OK);
    }

    @Operation(summary = "update task")
    @PutMapping("/tasks/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody RequestTask requestTask) {
        taskService.update(id, requestTask);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Operation(summary = "delete task")
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return new ResponseEntity<>(taskService.delete(id), HttpStatus.OK);
    }
}
