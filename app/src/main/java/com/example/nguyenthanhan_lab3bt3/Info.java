package com.example.nguyenthanhan_lab3bt3;

public class Info {
    String id;
    String fname;
    String lname;

    public Info(String id, String fname, String lname, int image, String phone, String mail) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.image = image;
        this.phone = phone;
        this.mail = mail;
    }

    int image;
    String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
