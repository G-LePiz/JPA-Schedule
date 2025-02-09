package com.example.jpa3.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String todo;

    private final String user;

    public ScheduleResponseDto(Long id, String todo, String user) {
        this.id = id;
        this.todo = todo;
        this.user = user;
    }
}
