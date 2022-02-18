package com.taskTracker.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.taskTracker.model.enums.StatusOfTheProject;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestUpdateProject {
    private String name;
    @JsonProperty("status_of_the_project")
    private StatusOfTheProject statusOfTheProject;
    private int priority;
}
