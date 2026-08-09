CREATE TABLE workouts (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    started_at TIMESTAMP,
    user_id BIGINT NOT NULL,

    CONSTRAINT fk_workouts_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
);

CREATE TABLE workout_exercises (
    id BIGSERIAL PRIMARY KEY,
    workout_id BIGINT NOT NULL,
    exercise_id BIGINT NOT NULL,

    CONSTRAINT fk_workout_exercises_workout
        FOREIGN KEY (workout_id)
        REFERENCES workouts(id),

    CONSTRAINT fk_workout_exercises_exercise
        FOREIGN KEY (exercise_id)
        REFERENCES exercises(id)
);

CREATE TABLE workout_sets (
    id BIGSERIAL PRIMARY KEY,
    set_number INTEGER NOT NULL,
    repetitions INTEGER NOT NULL,
    weight NUMERIC(10, 2),
    workout_exercise_id BIGINT NOT NULL,

    CONSTRAINT fk_workout_sets_workout_exercise
        FOREIGN KEY (workout_exercise_id)
        REFERENCES workout_exercises(id)
);