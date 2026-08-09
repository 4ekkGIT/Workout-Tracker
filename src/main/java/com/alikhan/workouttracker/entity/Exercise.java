package com.alikhan.workouttracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exercises")
@Getter
@Setter
@NoArgsConstructor
public class Exercise {

    @GeneratedValue
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExerciseCategory category;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @ElementCollection(targetClass = MuscleGroup.class)
    @CollectionTable
            (name = "exercise_muscle_groups",
            joinColumns = @JoinColumn(name = "exercise_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "muscle_group", nullable = false)
    private Set<MuscleGroup> muscleGroups = new HashSet<>();

    @OneToMany(mappedBy = "exercise")
    private Set<WorkoutExercise> workoutExercises = new HashSet<>();
}
