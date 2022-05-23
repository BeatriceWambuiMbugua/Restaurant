package com.digitalspaceguru.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView)
    TextView mlocationTextView;
    @BindView(R.id.listView)
    ListView mListView;
    private String[] restaurants = new String[]{"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        //mlocationTextView = (TextView) findViewById(R.id.locationTextView);
        // mListView = (ListView) findViewById(R.id.listView);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView) view).getText().toString();
                Log.v("RestaurantsActivity", "In the onItemClickListener!");
                Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mlocationTextView.setText("Here are the restaurants near the place: " + location);//call the setText() method on mLocationTextView to update its text to contain the sentence we include, and the location string we previously defined.
        Log.d("RestaurantsActivity", "In the onCreate method!");
    }
}