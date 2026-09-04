package com.alikhan.workouttracker.service.impl;

import com.alikhan.workouttracker.entity.Exercise;
import com.alikhan.workouttracker.exception.ExerciseNotFoundException;
import com.alikhan.workouttracker.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise getExerciseById(Long id) {
        return exerciseRepository.findById(id).orElseThrow(() -> new ExerciseNotFoundException("Exercise not found"));
    }
}
