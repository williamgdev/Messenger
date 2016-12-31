package com.adnroid.devcuba.messengerproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adnroid.devcuba.messengerproject.firebase.RegisterUser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RegisterUser registerUser = RegisterUser.getInstance();
        
    }
}
