package com.adnroid.devcuba.messengerproject;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adnroid.devcuba.messengerproject.Utils.Utils;
import com.adnroid.devcuba.messengerproject.firebase.RegisterUser;
import com.adnroid.devcuba.messengerproject.firebase.User;
import com.adnroid.devcuba.messengerproject.fragment.UserFragment;

public class MainActivity extends AppCompatActivity implements UserFragment.OnRegisterUserListener {

    RegisterUser registerUser = RegisterUser.getInstance();
    UserFragment userFragment;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Utils.checkIsPhone(this)) {
            init();
        } else {
            // showError();
        }


    }

    private void init() {
        Utils.requestContactPermition(this);

        userFragment = new UserFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_layout, userFragment)
                .commit();
    }


    //----------------------

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Utils.getContacts(this);


                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }

    }

    @Override
    public void onFragmentInteraction(User user) {
        if (registerUser.saveUser(user)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(userFragment)
                    .commit();
        }
    }


    //--------------------------


}
