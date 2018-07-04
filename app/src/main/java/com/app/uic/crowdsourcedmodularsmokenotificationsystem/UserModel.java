package com.app.uic.crowdsourcedmodularsmokenotificationsystem;

public class UserModel {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getPass() {
//        return pass;
//    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserModel() {
        this.id = "";
        this.pass = "";
        this.email = "";
    }

    @Override
    public String toString() {
        return this.pass;
    }

    private String id;
    private String pass;
    private String email;


}