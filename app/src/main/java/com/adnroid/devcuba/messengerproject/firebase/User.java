package com.adnroid.devcuba.messengerproject.firebase;

/**
 * Created by User on 12/30/2016.
 */

public class User {
    private String name;

    private String phone;
    private String passwd;

    public User() {
    }

    public User(String name, String phone, String passwd) {
        this.name = name;
        this.phone = phone;
        this.passwd = passwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
