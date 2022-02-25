//package com.taskTracker.service;
//
//import com.taskTracker.api.request.RequestProject;
//import com.taskTracker.model.Project;
//import com.taskTracker.model.enums.StatusOfTheProject;
//import com.taskTracker.repository.ProjectRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//class ProjectServiceTest {
//    @Autowired
//    private ProjectService projectService;
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    @Test
//    void create() {
//        RequestProject requestProject = new RequestProject();
//        requestProject.setName("New project");
//        requestProject.setStatusOfTheProject(StatusOfTheProject.Completed);
//        requestProject.setPriority(2);
//
//        long id = projectService.create(requestProject);
//        assertEquals(1, id);
//    }
//
//    @Test
//    void view() {
//        Project project = new Project();
//        project.setName("First project");
//        project.setPriority(1);
//        project.setStatusOfTheProject(StatusOfTheProject.Active);
//        projectRepository.save(project);
//
//        Project p = projectService.view(1);
//        assertEquals(1, p.getId());
//    }
//}