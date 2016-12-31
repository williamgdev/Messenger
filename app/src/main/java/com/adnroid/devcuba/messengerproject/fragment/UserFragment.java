package com.adnroid.devcuba.messengerproject.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adnroid.devcuba.messengerproject.R;
import com.adnroid.devcuba.messengerproject.firebase.User;

public class UserFragment extends Fragment {

    private OnRegisterUserListener mListener;
    Button bRegister;
    EditText txtName, txtPhone, txtPasswd, txtConfirmPasswd;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.user_register, container, false);
        bRegister = (Button) view.findViewById(R.id.user_register_button_register);
        txtName = (EditText) view.findViewById(R.id.user_register_txtname);
        txtPhone = (EditText) view.findViewById(R.id.user_register_txtphone);
        txtPasswd = (EditText) view.findViewById(R.id.user_register_txtpasswd);
        txtConfirmPasswd = (EditText) view.findViewById(R.id.user_register_txtpasswdconfirm);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtPasswd.getText().toString().equals(txtConfirmPasswd.getText().toString())){
                    User user = new User(
                            txtName.getText().toString(),
                            txtPhone.getText().toString(),
                            txtPasswd.getText().toString()
                    );
                    mListener.onFragmentInteraction(user);
                }
                else
                    Toast.makeText(view.getContext(), "Please check your password", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRegisterUserListener) {
            mListener = (OnRegisterUserListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRegisterUserListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnRegisterUserListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(User user);
    }
}