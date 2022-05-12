package com.digitalspaceguru.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mFindRestaurantsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //is called every time a user visits this activity.
        super.onCreate(savedInstanceState); //causes Android to run all of the default behaviors for an activity.
        setContentView(R.layout.activity_main); //setContentView tells the activity which layout to use for the device screen.
        //R.layout.activity_main tells Android to use the main_activity.xml layout for this activity. R - which is short for Resources - gives us a way to access all of our files in the res directory.
        mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton);

        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                startActivity(intent);
            }
        });
    }
}