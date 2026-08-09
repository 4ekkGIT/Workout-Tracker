CREATE TABLE exercises (
    id BIGSERIAL PRIMARY KEY,
    category VARCHAR(255),
    name VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(255)
);

CREATE TABLE exercise_muscle_groups (
    exercise_id BIGINT NOT NULL,
    muscle_group VARCHAR(255) NOT NULL,

    CONSTRAINT pk_exercise_muscle_groups
        PRIMARY KEY (exercise_id, muscle_group),

    CONSTRAINT fk_exercise_muscle_groups_exercise
        FOREIGN KEY (exercise_id)
        REFERENCES exercises(id)
);