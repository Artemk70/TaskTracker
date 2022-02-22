package com.taskTracker.service;

import com.taskTracker.api.request.RequestProject;
import com.taskTracker.model.Project;
import com.taskTracker.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public long create(RequestProject requestProject) {
        Project project = new Project();
        project.setName(requestProject.getName());
        project.setStartDate(LocalDateTime.now());
        project.setStatusOfTheProject(requestProject.getStatusOfTheProject());
        project.setPriority(requestProject.getPriority());

        Project saveProject = projectRepository.save(project);
        return saveProject.getId();
    }

    public Project view(long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        return optionalProject.orElseGet(Project::new);
    }

    @Transactional
    public void update(long id, RequestProject requestProject) throws Exception {
        if (projectRepository.getById(id).getId() == id) {
            projectRepository.update(id, requestProject.getName(), requestProject.getStatusOfTheProject(),
                    requestProject.getPriority());
        } else {
            throw new Exception("The project with this id does not exist");
        }
    }

    public long delete(long id) {
        Project project = projectRepository.getById(id);
        if (project.getId() == id) {
            projectRepository.deleteById(id);
            return id;
        } else {
            return 0;
        }
    }
}
