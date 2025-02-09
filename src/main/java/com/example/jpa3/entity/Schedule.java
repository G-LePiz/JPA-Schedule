package com.example.jpa3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String todo;

    private String user;

    public Schedule(String todo, String user) {
        this.todo = todo;
        this.user = user;
    }

    public void update(String todo){
        this.todo = todo;
    }
}
