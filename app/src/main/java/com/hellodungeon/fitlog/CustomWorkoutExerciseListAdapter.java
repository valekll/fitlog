package com.hellodungeon.fitlog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomWorkoutExerciseListAdapter extends
        RecyclerView.Adapter<CustomWorkoutExerciseListAdapter.CustomWorkoutExerciseListViewHolder> {

    private Context mCtxt;
    private ArrayList<Exercise> exercises;

    class CustomWorkoutExerciseListViewHolder extends RecyclerView.ViewHolder {
        ImageView exerciseImg, closeButtonImg;
        TextView exerciseName;

        public CustomWorkoutExerciseListViewHolder(@NonNull View itmView) {
            super(itmView);
            exerciseName = itmView.findViewById(R.id.customWOActivityExercise);
        } //CustomWorkoutExerciseListViewHolder()

    } //CustomWorkoutExerciseListViewHolder

    public CustomWorkoutExerciseListAdapter(Context mCtxt, ArrayList<Exercise> exercises) {
        this.mCtxt = mCtxt;
        this.exercises = exercises;
    } //CustomWorkoutExerciseListAdapter()

    @NonNull
    @Override
    public CustomWorkoutExerciseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater infl = LayoutInflater.from(mCtxt);
        View view = infl.inflate(R.layout.add_custom_wo_activity_layout, null, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));
        return new CustomWorkoutExerciseListViewHolder(view);
    } //onCreateViewHolder()

    @Override
    public void onBindViewHolder(@NonNull CustomWorkoutExerciseListViewHolder holder, int pos) {
        Exercise exercise = exercises.get(pos);
        holder.exerciseName.setText(exercise.getName());
    } //onBindViewHolder()

    @Override
    public int getItemCount() {
        return exercises.size();
    } //getItemCount()
} //CustomWorkoutExerciseListAdapter
