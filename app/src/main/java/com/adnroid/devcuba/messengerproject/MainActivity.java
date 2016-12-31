package com.adnroid.devcuba.messengerproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adnroid.devcuba.messengerproject.firebase.RegisterUser;
import com.adnroid.devcuba.messengerproject.firebase.User;
import com.adnroid.devcuba.messengerproject.fragment.UserFragment;

public class MainActivity extends AppCompatActivity implements UserFragment.OnRegisterUserListener{

    private static final String TAG = "MainActivity";
    RegisterUser registerUser = RegisterUser.getInstance();
    UserFragment userFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userFragment = new UserFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_layout, userFragment)
                .commit();
    }

    @Override
    public void onFragmentInteraction(User user) {
        if(registerUser.saveUser(user)){
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(userFragment)
                    .commit();
        }
    }
}
