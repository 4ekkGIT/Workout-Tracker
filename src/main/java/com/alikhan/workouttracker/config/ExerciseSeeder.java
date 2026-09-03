package com.alikhan.workouttracker.config;

import com.alikhan.workouttracker.entity.Exercise;
import com.alikhan.workouttracker.entity.ExerciseCategory;
import com.alikhan.workouttracker.entity.MuscleGroup;
import com.alikhan.workouttracker.repository.ExerciseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class ExerciseSeeder implements CommandLineRunner {

    private final ExerciseRepository exerciseRepository;

    public ExerciseSeeder(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void run(String... args) {
        Exercise benchPress = new Exercise();
        benchPress.setName("Barbell Bench Press");
        benchPress.setDescription("Barbell Chest Press");
        benchPress.setCategory(ExerciseCategory.STRENGTH);
        benchPress.setMuscleGroups(Set.of(
                MuscleGroup.CHEST,
                MuscleGroup.TRICEPS,
                MuscleGroup.SHOULDERS
        ));

        Exercise squat = new Exercise();
        squat.setName("Barbell Squat");
        squat.setDescription("Compound lower body exercise");
        squat.setCategory(ExerciseCategory.STRENGTH);
        squat.setMuscleGroups(Set.of(
                MuscleGroup.QUADS,
                MuscleGroup.GLUTES,
                MuscleGroup.HAMSTRINGS
        ));

        saveIfNotExists(benchPress);
        saveIfNotExists(squat);
    }

    private void saveIfNotExists(Exercise exercise) {
        if (!exerciseRepository.existsByName(exercise.getName())) {
            exerciseRepository.save(exercise);
        }
    }
}