package com.example.nguyenthanhan_lab3bt3;

import android.app.Application;

import java.text.ParseException;
import java.util.ArrayList;

public class App extends Application { // Singleton Pattern
    public static ArrayList<Info> data;

    @Override
    public void onCreate() {
        super.onCreate();
        if (data == null) {
            data = new ArrayList<>();
        }
    }
    public static ArrayList<Info> initDataForCountry()  {
        data.add(new Info(1,"Zachary","Moore",R.drawable.moore,"(273)-352-7112","zachary.moore@example.com","20/11/1999",null));
        data.add(new Info(2,"Dominic","Thunes",R.drawable.thunes,"(067)-453-1128","dominic.thunes@example.com","20/11/1999",null));
        data.add(new Info(3,"Apolline","Renard",R.drawable.renard,"(027)-155-0657","apolline.renard@example.com","20/11/1999",null));
        data.add(new Info(4,"Maria","Pascual",R.drawable.pascual,"(094)-134-9948","maria.pascual@example.com","20/11/1999",null));
        data.add(new Info(5,"Djordy","Valkema",R.drawable.valkema,"(167)-351-1900","djordy.valkema@example.com","20/11/1999",null));
        data.add(new Info(6,"Jenny","Jones",R.drawable.jones,"(015)-242-8092","jenny.jones@example.com","20/11/1999",null));
        data.add(new Info(7,"Ceylan","catalbas",R.drawable.catalbas,"(536)-393-6219","ceylan.catalbas@example.com","20/11/1999",null));
        data.add(new Info(8,"Seraina","Henry",R.drawable.henry,"(077)-673-2231","seraina.henry@example.com","20/11/1999",null));
        return data;
    }
}
