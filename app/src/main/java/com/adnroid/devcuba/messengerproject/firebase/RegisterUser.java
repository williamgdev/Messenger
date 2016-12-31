package com.adnroid.devcuba.messengerproject.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/30/2016.
 */

public class RegisterUser {
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference myRef = database.getReference("users");
    private static List<User> users;
    private static final RegisterUser instance = new RegisterUser();

    private RegisterUser(){}

    public static RegisterUser getInstance(){
        saveUser(new User(
                "Willy",
                "1 111 1111",
                "123"
        ));
        saveUser(new User(
                "Yendry",
                "5 555 5555",
                "123"
        ));
        loadUsers();
        return instance;
    }

    public static void saveUser(User user){
        myRef.child(user.getPhone()).setValue(user);
    }

    public static void loadUsers(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                users = new ArrayList<>();
                for (DataSnapshot datasnapshop :
                        dataSnapshot.getChildren()) {
                    User user = datasnapshop.getValue(User.class);
                    users.add(user);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }

    public List<User> getAllUsers(){
        if (users == null) {
            return new ArrayList<>();
        }
        return users;
    }

    public boolean hasUsers(){
        return users.size() > 0;
    }

}
