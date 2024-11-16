package com.luxshan.todoappbackend.dto;

import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ToDoRequest implements Serializable {
    private Integer id;
    private String task;
    private boolean completed;
}