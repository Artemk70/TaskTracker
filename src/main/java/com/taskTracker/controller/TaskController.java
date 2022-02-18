package com.taskTracker.controller;

import com.taskTracker.api.request.RequestTask;
import com.taskTracker.model.Task;
import com.taskTracker.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/task/create")
    public ResponseEntity<?> create(@RequestBody RequestTask requestTask) {
        return new ResponseEntity<>(taskService.create(requestTask), HttpStatus.OK);
    }

    @GetMapping("task/{id}")
    public ResponseEntity<Task> view(@PathVariable long id) {
        return new ResponseEntity<>(taskService.view(id), HttpStatus.OK);
    }

    @PostMapping("/task/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody RequestTask requestTask) {
        return new ResponseEntity<>(taskService.update(id, requestTask), HttpStatus.OK);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return new ResponseEntity<>(taskService.delete(id), HttpStatus.OK);
    }
}
