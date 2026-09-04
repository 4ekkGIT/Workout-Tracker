package com.alikhan.workouttracker.exception;

public class ExerciseNotFoundException extends RuntimeException {

    public ExerciseNotFoundException(String message) {
        super(message);
    }
}
