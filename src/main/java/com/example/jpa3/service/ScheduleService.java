package com.example.jpa3.service;

import com.example.jpa3.dto.ScheduleRequestDto;
import com.example.jpa3.dto.ScheduleResponseDto;
import com.example.jpa3.entity.Schedule;
import com.example.jpa3.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule(scheduleRequestDto.getTodo(), scheduleRequestDto.getUser());
        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(), schedule.getTodo(), schedule.getUser());
    }

    public List<ScheduleResponseDto> findall() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleResponseDto(schedule.getId(), schedule.getTodo(), schedule.getUser()));
        }

        return dtos;
    }

    public ScheduleResponseDto findById(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("일정이 없습니다")
        );

        return new ScheduleResponseDto(schedule.getId(), schedule.getTodo(), schedule.getUser());
    }

    public ScheduleResponseDto update(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("일정 수정이 불가능")
        );

        schedule.update(schedule.getTodo());

        return new ScheduleResponseDto(schedule.getId(), schedule.getTodo(), schedule.getUser());
    }

    public void delete(Long id) {

        scheduleRepository.deleteById(id);
    }
}
