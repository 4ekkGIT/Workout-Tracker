package com.alikhan.workouttracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "workout_sets")
@Getter
@Setter
@NoArgsConstructor
public class WorkoutSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1)
    @Column(nullable = false)
    private int setNumber;

    @Min(0)
    private int repetitions;

    private BigDecimal weight;

    @ManyToOne
    @JoinColumn(name = "workout_exercise_id", nullable = false)
    private WorkoutExercise workoutExercise;
}
