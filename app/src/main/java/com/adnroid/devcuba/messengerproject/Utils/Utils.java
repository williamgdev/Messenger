package com.adnroid.devcuba.messengerproject.Utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by User on 12/30/2016.
 */

public class Utils {





    private static final String TAG = Utils.class.getSimpleName();

    public static void getContacts(Context context) {
         List<String> listPhone = new ArrayList<>();
         List<String> listName = new ArrayList<>();


            Cursor cursorPhone = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    null, null, null);
            cursorPhone.moveToFirst();


            Cursor cursorID = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                    null,
                    null, null, null);


            cursorID.moveToFirst();

        if(cursorPhone.getCount()>0){
        do{
            listPhone.add(cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
            Log.d(TAG, "retrieveContactNumber: "+cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
        }while (cursorPhone.moveToNext());
        cursorPhone.close();
        }
        if(cursorID.getCount()>0) {
            do {
                listName.add(cursorID.getString(cursorID.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
                Log.d(TAG, "retrieveContactNumber: " + cursorID.getString(cursorID.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
            } while (cursorID.moveToNext());
            cursorID.close();
            Log.d(TAG, "SIZE: " + listName.size() + " - " + listPhone.size());
        }
    }



    public static void requestContactPermition(Activity activity){
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.READ_CONTACTS)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }else {
            //ejecutalo aki

            getContacts(activity);
        }


    }
    public static boolean checkIsPhone(Context context){
        TelephonyManager manager = (TelephonyManager)context.getSystemService(context.TELEPHONY_SERVICE);
        if(manager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE){
            Log.d(TAG, "checkIsPhone: Tablet");
            return false;
        }else{
            Log.d(TAG, "checkIsPhone: Phone");
            return true;
        }
    }
}
