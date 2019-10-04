package com.hellodungeon.fitlog;

/**
 * A log containing information about a workout.
 */
public class WorkoutLog {
    private int id;
    private String date;
    private int gradeImage;
    private Workout wkout;

    public WorkoutLog(int id, String date, int gradeImage) {
        this.id = id;
        this.date = date;
        this.gradeImage = gradeImage;
    } //WorkoutLog()

    public int getId() {
        return id;
    } //getId()

    public void setId(int id) {
        this.id = id;
    } //setId()

    public String getDate() {
        return date;
    } //getDate()

    public void setDate(String date) {
        this.date = date;
    } //setDate()

    public int getGradeImage() {
        return gradeImage;
    } //getGradeImage()

    public void setGradeImage(int gradeImage) {
        this.gradeImage = gradeImage;
    } //setGradeImage()

} //WorkoutLog
