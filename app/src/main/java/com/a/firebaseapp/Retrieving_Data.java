package com.a.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Retrieving_Data extends AppCompatActivity {
    private TextView value;
    Firebase ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieving__data);
        value = (TextView) findViewById(R.id.value);
        ref = new Firebase("https://fir-app-51593.firebaseio.com/Users/Name");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String valueFromDatabase = dataSnapshot.getValue(String.class);
                value.setText(valueFromDatabase);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
