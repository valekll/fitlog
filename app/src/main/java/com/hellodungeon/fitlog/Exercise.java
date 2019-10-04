package com.hellodungeon.fitlog;

import java.util.ArrayList;

/**
 * A representation of an exercise as a collection of sets of repetitions.
 */
class Exercise {
    private String name;
    private ArrayList<ExerciseSet> sets;

    public Exercise(String name) {
        this.name = name;
        sets = new ArrayList<>(0);
    } //Exercise()

    public String getName() {
        return name;
    } //getName()

    public void setName(String name) {
        this.name = name;
    } //setName()

    public ArrayList<ExerciseSet> getSets() {
        return sets;
    } //getSets()

    public void setSets(ArrayList<ExerciseSet> sets) {
        this.sets = sets;
    } //setSets()

    public void addSet(ExerciseSet set) {
        this.sets.add(set);
    } //addSet()

    public void removeSet(ExerciseSet set) {
        this.sets.remove(set);
    } //addSet()
} //Exercise
