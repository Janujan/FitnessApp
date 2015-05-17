package com.example.janujanselva.fitnessapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Main Activity", "Entered main activity");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v){}

    public void startWrk(View v){

        Toast.makeText(this,"You clicked the start workout button", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, startWorkout.class));
    }

    public void hist(View v){
        Toast.makeText(this,"You clicked the history button", Toast.LENGTH_LONG).show();
    }

    public void changeWrk(View v){
        Toast.makeText(this,"You clicked the change workout button", Toast.LENGTH_LONG).show();
    }

    public void settings(View v){
        Toast.makeText(this,"You clicked the settings button", Toast.LENGTH_LONG).show();

    }
}
