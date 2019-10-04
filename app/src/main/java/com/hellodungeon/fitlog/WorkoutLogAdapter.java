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


/**
 * Custom Adapter for the WorkoutLog cards.
 */
public class WorkoutLogAdapter extends RecyclerView.Adapter<WorkoutLogAdapter.WorkoutLogViewHolder> {

    private Context mCtxt;
    private ArrayList<WorkoutLog> workoutLogs;

    /**
     * Custom ViewHolder for the WorkoutLog cards.
     */
    class WorkoutLogViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView;
        TextView dateTxtView;

        /**
         * Constructor for WorkoutLogViewHolder
         * @param itemView View from which the items are found.
         */
        public WorkoutLogViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.gradeImgView);
            dateTxtView = itemView.findViewById(R.id.date_text);
        } //WorkoutLogViewHolder()
    } //WorkoutLogViewHolder

    /**
     * Constructor for the WorkoutLogAdapter
     * @param mCtxt the Context of the WorkoutLog
     * @param workoutLogs the WorkoutLogs
     */
    public WorkoutLogAdapter(Context mCtxt, ArrayList<WorkoutLog> workoutLogs) {
        this.mCtxt = mCtxt;
        this.workoutLogs = workoutLogs;
    } //WorkoutLogAdapter()

    /**
     * Inflates the list layout view specified by list_layout to a view to be used in the RecyclerView.
     * @param parent the ViewGroup of its parent
     * @param viewType the type of View
     * @return the resulting WorkoutLogViewHolder
     */
    @NonNull
    @Override
    public WorkoutLogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtxt);
        View view = inflater.inflate(R.layout.list_layout, null, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));
        return new WorkoutLogViewHolder(view);
    } //onCreateViewHolder()

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull WorkoutLogViewHolder holder, int position) {
        WorkoutLog workoutLog = workoutLogs.get(position);

        holder.dateTxtView.setText(workoutLog.getDate());
        holder.imgView.setImageDrawable(mCtxt.getResources().getDrawable(workoutLog.getGradeImage(), null));
    } //onBindViewHolder()

    /**
     * @return the number of WorkoutLogs
     */
    @Override
    public int getItemCount() {
        return workoutLogs.size();
    } //getItemCount()
} //WorkoutLogAdapter
