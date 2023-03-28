package com.example.nguyenthanhan_lab3bt3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

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
       if(infos==null){ infos = App.initDataForCountry();}
        rvInfo = findViewById(R.id.rvInfo);
        getSupportActionBar().setTitle("Contact");

        infoAdapter = new InfoAdapter(infos,MainActivity.this);
        rvInfo.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        rvInfo.setAdapter(infoAdapter);
        btAddContact = findViewById(R.id.btAddContact);
        btAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, AddEditContactActivity.class);
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

    @Override
    public void onEditListener(int pos, Info info) {
        Intent intent = new Intent (MainActivity.this, AddEditContactActivity.class);
        intent.putExtra("flag",2);
        intent.putExtra("infos",info);
        mLauncher.launch(intent);
    }

    @Override
    public void onDeleteListener(int pos, Info info) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Information");
        builder.setMessage("Delete ".concat(info.getFname()+ " "+info.getLname()).concat(" ?"));
        builder.setNegativeButton("No", (dialogInterface, i) -> {
            dialogInterface.cancel();

        });
        builder.setPositiveButton("Yes", (dialogInterface, i) -> {
           infoAdapter.deleteInfo(pos);
            dialogInterface.dismiss();

        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();}




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
//        androidx.appcompat.widget.SearchView searchView  = (androidx.appcompat.widget.SearchView) menu.findItem(R.id.menuSearch).getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                infoAdapter.getFilter().filter(query);
//                return false;
//            }
//            //
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                infoAdapter.getFilter().filter(newText);
//
//                //             if(newText.isEmpty()){
////                    btAddContact.setVisibility(View.VISIBLE);
////                }else {
////                    fabAddContact.setVisibility(View.INVISIBLE);
////                }
//                return false;
//            }
//        });


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuSort){

            Collections.sort(infos);
            infoAdapter.notifyDataSetChanged();
        }
        if (item.getItemId() == R.id.menuSearch) {
            infos.clear();
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }



}



