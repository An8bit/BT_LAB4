package com.example.nguyenthanhan_lab3bt3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements InfoAdapter.Listener {

    RecyclerView rvInfo;
    InfoAdapter infoAdapter;
    ArrayList<Info> infos;
    int position;
    FloatingActionButton btAddContact;


    ActivityResultLauncher<Intent> mLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()==RESULT_OK){
                        if(result.getData().getIntExtra("flag",0)==1){
                            Info info = (Info) result.getData().getSerializableExtra("contact");
                            infoAdapter.addInfo(info);
                        }else {
                            Info info=(Info) result.getData().getSerializableExtra("contact");
                            infoAdapter.editInfo(info,position);
                        }
                    }
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvInfo = findViewById(R.id.rvInfo);
        infos = App.initDataForCountry();
        infoAdapter = new InfoAdapter(infos,MainActivity.this);
        rvInfo.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        rvInfo.setAdapter(infoAdapter);
        btAddContact = findViewById(R.id.btAddContact);
        btAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this,AddContactActivity.class);
                intent.putExtra("flag",1);
               mLauncher.launch(intent);
            }
        });

    }

    @Override
    public void onClickListener(int pos, Info info) {
        Intent intent = new Intent(MainActivity.this, detiles.class);
        intent.putExtra("infos",info ); // truyền dữ liệu giữa các activity: truyền dữ liệu vào intent
        startActivity(intent);
    }
}