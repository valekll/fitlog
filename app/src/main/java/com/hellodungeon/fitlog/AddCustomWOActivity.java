package com.hellodungeon.fitlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Screen to add a custom workout to the log.
 */
public class AddCustomWOActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private CustomWorkoutExerciseListAdapter cwelAdapter;
    private ArrayList<Exercise> exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_custom_wo);

        buildToolbar();
        buildRecyclerView();
    } //onCreate()

    /**
     * Builds a RecyclerView to store the exercises for the Custom Workout.
     */
    public void buildRecyclerView() {
        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewAddCustomWO);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        for(int i = 0; i < 10; i++) {
            String name = "exercise " + (i + 1);
            exercises.add(new Exercise(name));
        } //for

        cwelAdapter = new CustomWorkoutExerciseListAdapter(this, exercises);
        recyclerView.setAdapter(cwelAdapter);
    } //buildRecyclerView()

    /**
     * Builds a Toolbar/ActionBar for the Activity.
     */
    public void buildToolbar() {
        toolbar = (Toolbar)findViewById(R.id.toolbarAddCustomWOActivity);
        toolbar.setTitle(R.string.createWO);
        toolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);
    } //buildToolbar()

    /**
     * Nullifies the stock back animation.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    } //onBackPressed()

    /**
     * Nullifies the stock navigate up animation.
     */
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        overridePendingTransition(0,0);
        return false;
    } //onSupportNavigateUp()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_wo_activity_menu, menu);
        return true;
    } //onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.nextButtonAddCustomWOActivity:
                Toast.makeText(getApplicationContext(), "Next", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        } //switch
    } //onOptionsItemSelected()
} //AddCustomWOActivity

