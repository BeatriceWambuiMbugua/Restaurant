package com.digitalspaceguru.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //public static final String TAG = MainActivity.class.getSimpleName();
    //  private Button mFindRestaurantsButton;
    // private EditText mLocationEditText;
    @BindView(R.id.findRestaurantsButton)
    Button mFindRestaurantsButton;
    @BindView(R.id.locationEditText)
    EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //is called every time a user visits this activity.
        super.onCreate(savedInstanceState); //causes Android to run all of the default behaviors for an activity.
        setContentView(R.layout.activity_main); //setContentView tells the activity which layout to use for the device screen.
        //R.layout.activity_main tells Android to use the main_activity.xml layout for this activity. R - which is short for Resources - gives us a way to access all of our files in the res directory.
        // mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton);
        // mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        ButterKnife.bind(this);

        mFindRestaurantsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mFindRestaurantsButton){
            String location = mLocationEditText.getText().toString();//getText() method returns an editable data type so we have to convert it to a String using the toString() method
            Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }

    }
}