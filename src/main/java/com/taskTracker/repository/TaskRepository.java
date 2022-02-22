package com.taskTracker.repository;

import com.taskTracker.model.Task;
import com.taskTracker.model.enums.StatusOfTheProject;
import com.taskTracker.model.enums.StatusOfTheTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Modifying
    @Query("UPDATE Task t " +
            "SET t.name = :name, t.statusOfTheTask = :statusOfTheTask, t.description = :description, t.project.id = :projectId " +
            "WHERE t.id = :id")
    void update(long id, String name, StatusOfTheTask statusOfTheTask, String description, long projectId);
}
