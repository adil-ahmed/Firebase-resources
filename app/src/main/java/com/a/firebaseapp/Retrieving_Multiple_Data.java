package com.a.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class Retrieving_Multiple_Data extends AppCompatActivity {

    Firebase ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieving__multiple__data);
        ref = new Firebase("https://fir-app-51593.firebaseio.com/Users");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String,String> map = dataSnapshot.getValue(Map.class);
                String name  = map.get("Name");
                String age = map.get("-KywcPPWilw9KzL_cg3u");
                //Log.d("E-VALUE","Data: "+ dataSnapshot.getValue());
                Log.d("E-VALUE","Name : " + name);
                Log.d("E-VALUE","Age : " + age);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
