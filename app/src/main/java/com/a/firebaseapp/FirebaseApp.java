package com.a.firebaseapp;

import android.app.Application;

import com.firebase.client.Firebase;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Adil on 11/15/2017.
 */
/*This class is for adding firebase in
every single activity and make sure that
you added the file name in manifest*/
public class FirebaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
