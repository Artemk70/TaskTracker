package com.taskTracker.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.io.Serializable;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusOfTheProject implements Serializable {
    NotStarted,
    Active,
    Completed

}
