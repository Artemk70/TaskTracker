package com.taskTracker.model;

import com.taskTracker.model.enums.StatusOfTheTask;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "task")
@Data
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "enum('ToDo','InProgress','Done')")
    private StatusOfTheTask statusOfTheTask;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Project project;
}
