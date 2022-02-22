package com.taskTracker.controller;

import com.taskTracker.AbstractTest;
import com.taskTracker.repository.ProjectRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class ProjectControllerTest extends AbstractTest {
    @Autowired
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setup() {
        super.setup();
    }

    @AfterEach
    public void cleanup() {
        projectRepository.deleteAll();
    }

    @Test
    void create() throws Exception {
        String json = "{\n" +
                "    \"name\": \"First Project\",\n" +
                "    \"status_of_the_project\": \"NotStarted\",\n" +
                "    \"priority\": 1\n" +
                "}";

        mockMvc.perform(post("/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
                .accept((MediaType) MockMvcResultMatchers.status().isOk()));
    }
}