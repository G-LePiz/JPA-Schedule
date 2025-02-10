package com.example.jpa3.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String todo;

    private final String user;

    private final LocalDateTime createDate;

    private final LocalDateTime updateDate;

    public ScheduleResponseDto(Long id, String todo, String user, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.todo = todo;
        this.user = user;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

}
