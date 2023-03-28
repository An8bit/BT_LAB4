package com.example.nguyenthanhan_lab3bt3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Info implements Serializable, Comparable<Info> {
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

    public Info(int id, String fname, String lname, int image, String phone, String mail,String birthday,byte[] bitmap) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.image = image;
        this.phone = phone;
        this.mail = mail;
        this.birthday=birthday;
        this.imgBit=bitmap;
    }

    int image;


    public Bitmap getImgBit() {
        return BitmapFactory.decodeByteArray(this.imgBit, 0, this.imgBit.length);
    }

    public void setImgBit(byte[] imgBit) {
        this.imgBit = imgBit;
    }

    byte[] imgBit;
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

    @Override
    public int compareTo(Info info) {
       if(fname.compareToIgnoreCase(info.fname)==0){
           return lname.compareToIgnoreCase(info.lname);
       }
       return fname.compareToIgnoreCase(info.fname);
    }

}
