package com.example.janujanselva.shottracker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class Shots_Tracks extends ActionBarActivity{

    static final String MADE_TWO = "Made Two";
    static final String MADE_THREE="Made Three";
    TextView twoVal;
    TextView threeVal;
    Button _increaseTwo;
    Button _decreaseTwo;
    Button _increaseThree;
    Button _decreaseThree;
    protected int madeTwo = 0;
    protected int madeThree = 0;
    String _madeTwo;
    String _madeThree;
    protected int _attemptTwos = 30;
    protected int _attemptThrees = 30;
    DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shots__tracks);

        TextView twoVal = (TextView)findViewById(R.id.madeTwos);
        TextView threeVal = (TextView)findViewById(R.id.madeThrees);

        twoVal.setText("0");
        threeVal.setText("0");
        db = new DatabaseHandler(getApplicationContext());
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(MADE_TWO, madeTwo);
        savedInstanceState.putInt(MADE_THREE, madeThree);
        Log.i("Info", "onSaveInstanceState");



    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i("Info", "onRestoreInstanceState");
        TextView twoVal = (TextView)findViewById(R.id.madeTwos);
        TextView threeVal = (TextView)findViewById(R.id.madeThrees);

        twoVal.setText(String.valueOf(savedInstanceState.getInt(MADE_TWO)));
        threeVal.setText(String.valueOf(savedInstanceState.getInt(MADE_THREE)));

        madeTwo = savedInstanceState.getInt(MADE_TWO);
        madeThree = savedInstanceState.getInt(MADE_THREE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shots__tracks, menu);
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

    public void onClick(View view){}


    public void twoIncrease(View view){
        TextView twoVal = (TextView)findViewById(R.id.madeTwos);
        madeTwo++;
        if(madeTwo > _attemptTwos )
        {
            madeTwo = _attemptTwos;
        }
        Log.d("Info", "Increasing Two");
        _madeTwo = Integer.toString(madeTwo);
        twoVal.setText(_madeTwo);

    }

    public void twoDecrease(View view){
        TextView twoVal = (TextView)findViewById(R.id.madeTwos);
        madeTwo--;
        if(madeTwo < 0)
        {
            madeTwo = 0;
        }
        Log.d("Info", "Decreasing Two");
        _madeTwo = Integer.toString(madeTwo);
        twoVal.setText(_madeTwo);
    }

    public void threeIncrease(View view){
        TextView twoVal = (TextView)findViewById(R.id.madeThrees);
        madeThree++;
        if(madeThree > _attemptThrees)
        {
            madeThree = _attemptThrees;
        }
        _madeThree = Integer.toString(madeThree);
        twoVal.setText(_madeThree);
    }

    public void threeDecrease(View view){
        TextView twoVal = (TextView)findViewById(R.id.madeThrees);
        madeThree--;
        if(madeThree < 0)
        {
            madeThree = 0;
        }
        _madeThree = Integer.toString(madeThree);
        twoVal.setText(_madeThree);
    }

    public void save(View view){
        Workout workout = new Workout(db.getWorkoutCount(), madeTwo, _attemptTwos, madeThree, _attemptThrees );
        db.createWorkout(workout);
        Toast.makeText(getApplicationContext(),"Saved Workout!", Toast.LENGTH_SHORT).show();
    }

}
