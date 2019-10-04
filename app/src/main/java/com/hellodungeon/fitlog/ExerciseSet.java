package com.hellodungeon.fitlog;

/**
 * A collection of repetitions of an exercise.
 */
class ExerciseSet {
    private int load;
    private int reps;

    public ExerciseSet(int load, int reps) {
        this.load = load;
        this.reps = reps;
    } //ExerciseSet()

    public int getLoad() {
        return load;
    } //getLoad()

    public void setLoad(int load) {
        this.load = load;
    } //setLoad()

    public int getReps() {
        return reps;
    } //getReps()

    public void setReps(int reps) {
        this.reps = reps;
    } //setReps()
} //ExerciseSet
