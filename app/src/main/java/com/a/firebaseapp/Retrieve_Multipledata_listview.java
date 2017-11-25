package com.a.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Retrieve_Multipledata_listview extends AppCompatActivity {

    ListView listView;
    ArrayList<String> name;
    ArrayList<String> keys;
    Firebase ref;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve__multipledata_listview);
        listView = (ListView) findViewById(R.id.listview);

        /*ref for normal listview using firebase*/
        /*ref = new Firebase("https://fir-app-51593.firebaseio.com/People");
        name = new ArrayList<>();
        keys = new ArrayList<>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        listView.setAdapter(arrayAdapter);
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                String key = dataSnapshot.getKey();
                name.add(value);
                keys.add(key);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                String key = dataSnapshot.getKey();
                int index = keys.indexOf(key);
                name.set(index,value);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String key = dataSnapshot.getKey();
                int index = keys.indexOf(key);
                name.remove(index);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/
        /*databaseReference for updated listview using firebase*/

        /*Database reference different way*/
        //databaseReference = FirebaseDatabase.getInstance().getReference();


        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-app-51593.firebaseio.com/People");
        FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>
                (       Retrieve_Multipledata_listview.this,
                        String.class,
                        android.R.layout.simple_list_item_1,
                        databaseReference
                       // databaseReference.child("People") //calling that different database
                ) {
            @Override
            protected void populateView(View v, String model, int position) {
                TextView textView = (TextView) v.findViewById(android.R.id.text1);
                textView.setText(model);
            }
        };

        listView.setAdapter(firebaseListAdapter);
    }
}
