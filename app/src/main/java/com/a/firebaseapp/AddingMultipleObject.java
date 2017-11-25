package com.a.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class AddingMultipleObject extends AppCompatActivity {
    Button insert;
    EditText valueInsert,keyInsert;
    Firebase refRoot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_multiple_object);
        refRoot = new Firebase("https://fir-app-51593.firebaseio.com/Users");
        insert = (Button) findViewById(R.id.button2);
        valueInsert = (EditText) findViewById(R.id.editText);
        keyInsert = (EditText) findViewById(R.id.editText2);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = valueInsert.getText().toString();//text to string
                String key = keyInsert.getText().toString();//text to string
               /* Firebase childRef = refRoot.child("Name");//add values to(replace) Name,does not create a new child
                childRef.setValue(value);*/
               Firebase childRef = refRoot.child(key);//inserting key
               childRef.setValue(value);//adding value to that key
               //childRef.push().setValue(value);//create a new unique child.Does not replace the previous one
            }
        });
    }
}
