package com.taskTracker.repository;

import com.taskTracker.model.Project;
import com.taskTracker.model.enums.StatusOfTheProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Modifying
    @Query("UPDATE Project p " +
            "SET p.name = :name, p.statusOfTheProject = :statusOfTheProject, p.priority = :priority " +
            "WHERE p.id = :id")
    void update(long id, String name, StatusOfTheProject statusOfTheProject, int priority);
}
