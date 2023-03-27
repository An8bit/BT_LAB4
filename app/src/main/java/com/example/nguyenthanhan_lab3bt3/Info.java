package com.example.nguyenthanhan_lab3bt3;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Info implements Serializable {
    int id;
    String fname;
    String lname;
    String birthday;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday=birthday;
    }

    public Info(int id, String fname, String lname, int image, String phone, String mail,String birthday) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.image = image;
        this.phone = phone;
        this.mail = mail;
        this.birthday=birthday;
    }

    int image;
    String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    String mail;
}
