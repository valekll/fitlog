package com.hellodungeon.fitlog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WorkoutLogAdapter wolAdapter;
    private FloatingActionButton fab, fabs1, fabs2;
    private Animation fabOpen, fabClose, rotateFoward, rotateBackward;
    private Toolbar toolbar;
    private ArrayList<WorkoutLog> workoutLogs;
    private boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFABs();
        setToolbar();

        workoutLogs = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //set vertical recycler view

        for(int i = 0; i < 10; i++) {
            int day = 21 - i;
            String date = "05/" + day + "/19";
            workoutLogs.add(new WorkoutLog(i, date, R.drawable.torch));
        } //for

        wolAdapter = new WorkoutLogAdapter(this, workoutLogs);
        recyclerView.setAdapter(wolAdapter);
    } //onCreate()

    @Override
    public boolean onSupportNavigateUp() {
        Toast.makeText(this, "toasty", Toast.LENGTH_SHORT).show();
        return false;
    } //onSupportNavigateUp()

    private void setToolbar() {
        toolbar = (Toolbar)findViewById(R.id.toolbarMain);
        toolbar.setTitle(R.string.workouts);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);
    } //setToolbar

    /**
     * Sets animations for the FloatingActionButtons
     */
    private void animateFab() {
        if(isOpen) {
            fab.startAnimation(rotateFoward);
            fabs1.startAnimation(fabClose);
            fabs2.startAnimation(fabClose);
            fabs1.setClickable(false);
            fabs2.setClickable(false);
            isOpen = false;
        } //if
        else {
            fab.startAnimation(rotateBackward);
            fabs1.startAnimation(fabOpen);
            fabs2.startAnimation(fabOpen);
            fabs1.setClickable(true);
            fabs2.setClickable(true);
            isOpen = true;
        } //else
    } //animateFab()

    /**
     * Sets up the FloatingActionButtons.
     */
    private void setFABs() {
        fab = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        fabs1 = (FloatingActionButton)findViewById(R.id.floatingActionButtonSub1);
        fabs2 = (FloatingActionButton)findViewById(R.id.floatingActionButtonSub2);

        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        rotateFoward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            } //onClick()
        });

        fabs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAddCustomWOActivity();
            } //onClick()
        });
    } //setFABs()

    /**
     * Starts an intent to create a new workout.
     */
    private void goToAddCustomWOActivity() {
        Intent intent = new Intent(this, AddCustomWOActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    } //goToAddCustomWOActivity()
} //MainActivity
