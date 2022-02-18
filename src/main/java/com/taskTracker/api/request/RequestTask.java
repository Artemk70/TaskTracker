package com.taskTracker.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.taskTracker.model.enums.StatusOfTheTask;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestTask {
    private String name;
    @JsonProperty("status_of_the_task")
    private StatusOfTheTask statusOfTheTask;
    private String description;
    @JsonProperty("project_id")
    private long projectId;
}
