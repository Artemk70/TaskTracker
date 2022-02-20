package com.taskTracker.service;

import com.taskTracker.api.request.RequestTask;
import com.taskTracker.model.Project;
import com.taskTracker.model.Task;
import com.taskTracker.repository.ProjectRepository;
import com.taskTracker.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public Task create(RequestTask requestTask) {
        Optional<Project> optionalProject = projectRepository.findById(requestTask.getProjectId());
        Task task = new Task();

        if (optionalProject.isPresent()) {
            task.setName(requestTask.getName());
            task.setStatusOfTheTask(requestTask.getStatusOfTheTask());
            task.setDescription(requestTask.getDescription());
            task.setProject(optionalProject.get());

            return taskRepository.save(task);
        } else {
            return task;
        }
    }

    public Task view(long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.orElseGet(Task::new);
    }

    public Task update(long id, RequestTask requestTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = optionalTask.orElseGet(Task::new);
        if (optionalTask.isPresent()) {
            task.setName(requestTask.getName());
        }
        return taskRepository.save(task);
    }


    public long delete(long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            taskRepository.deleteById(id);
            return id;
        } else {
            return 0;
        }
    }
}
