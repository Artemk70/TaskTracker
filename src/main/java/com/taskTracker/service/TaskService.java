package com.taskTracker.service;

import com.taskTracker.api.request.RequestTask;
import com.taskTracker.model.Project;
import com.taskTracker.model.Task;
import com.taskTracker.repository.ProjectRepository;
import com.taskTracker.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void update(long id, RequestTask requestTask) throws Exception {
        if (taskRepository.getById(id).getId() == id) {
            taskRepository.update(id, requestTask.getName(), requestTask.getStatusOfTheTask(),
                    requestTask.getDescription(), requestTask.getProjectId());
        } else {
            throw new Exception("The project with this id does not exist");
        }
    }


    public void delete(long id) {
        taskRepository.deleteById(id);
    }
}
