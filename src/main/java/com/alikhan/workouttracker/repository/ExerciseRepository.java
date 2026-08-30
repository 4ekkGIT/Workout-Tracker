package com.alikhan.workouttracker.repository;

import com.alikhan.workouttracker.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {


}
