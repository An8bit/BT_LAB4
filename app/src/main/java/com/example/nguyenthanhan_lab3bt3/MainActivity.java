package com.example.nguyenthanhan_lab3bt3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements InfoAdapter.Listener {

    RecyclerView rvInfo;
    InfoAdapter infoAdapter;
    ArrayList<Info> infos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvInfo = findViewById(R.id.rvInfo);
        infos = App.initDataForCountry();
        infoAdapter = new InfoAdapter(infos,MainActivity.this);
        rvInfo.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));

        rvInfo.setAdapter(infoAdapter);
    }

    @Override
    public void onItemListener(Info info) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("CONSTACTS");
        builder.setIcon(getDrawable(info.getImage()));
        builder.setMessage(info.getFname()+" "+info.getLname()+"\n"+info.getPhone());
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}