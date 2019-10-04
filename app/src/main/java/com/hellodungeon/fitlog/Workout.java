package com.hellodungeon.fitlog;

import java.util.ArrayList;

/**
 * A collection of exercises done in a row.
 */
public class Workout {
    private String title;
    private ArrayList<Exercise> exercises;

    public Workout(String title) {
        this.title = title;
        exercises = new ArrayList<>(0);
    } //Workout()

    public String getTitle() {
        return title;
    } //getTitle()

    public void setTitle(String title) {
        this.title = title;
    } //setTitle()

    public ArrayList<Exercise> getExercises() {
        return exercises;
    } //getExercises()

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    } //setExercises()

    public void addExercises(Exercise exercise) {
        this.exercises.add(exercise);
    } //addExercises()

    public void removeExercises(Exercise exercise) {
        this.exercises.remove(exercise);
    } //addExercises()
} //Workout
