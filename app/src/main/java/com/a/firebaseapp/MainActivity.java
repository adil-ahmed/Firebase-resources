package com.a.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    Button addvalue;
    Firebase ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this); //adding firebase for single activity
        addvalue = (Button) findViewById(R.id.addvalue);
        //ref = new Firebase("https://fir-app-51593.firebaseio.com/");//initializing firebase ref through url of our database
        addvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase refChild = ref.child("Name");
                refChild.setValue("Smith");
            }
        });


    }
}
