package com.example.jpa3.controller;

import com.example.jpa3.dto.ScheduleRequestDto;
import com.example.jpa3.dto.ScheduleResponseDto;
import com.example.jpa3.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto scheduleRequestDto){
        return ResponseEntity.ok(scheduleService.save(scheduleRequestDto));
    }

    @GetMapping("/members")
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        return ResponseEntity.ok(scheduleService.findall());
    }

    @GetMapping("/members/{id]")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id, @RequestBody ScheduleRequestDto scheduleRequestDto){
        return ResponseEntity.ok(scheduleService.findById(id, scheduleRequestDto));
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<ScheduleResponseDto> update(@PathVariable Long id, @RequestBody ScheduleRequestDto scheduleRequestDto){
        return ResponseEntity.ok(scheduleService.update(id, scheduleRequestDto));
    }

    @DeleteMapping("/members/{id}")
    public void delete(@PathVariable Long id){
        scheduleService.delete(id);
    }

}
