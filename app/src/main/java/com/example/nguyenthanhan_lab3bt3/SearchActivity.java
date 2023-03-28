package com.example.nguyenthanhan_lab3bt3;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements InfoAdapter.Listener {

    RecyclerView rvInfo;
    InfoAdapter infoAdapter;

    ArrayList<Info> infos;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        infos = App.initDataForCountry();



        // Khởi tạo Adapter và RecyclerView
        rvInfo = findViewById(R.id.rvInfo);
        infoAdapter = new InfoAdapter(infos, SearchActivity.this);
        rvInfo.setAdapter(infoAdapter);
        rvInfo.setLayoutManager(new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, true));


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_search, menu);
        androidx.appcompat.widget.SearchView searchView  = (androidx.appcompat.widget.SearchView) menu.findItem(R.id.menuSearchh).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                infoAdapter.getFilter().filter(query);
                return false;
            }
            //
            @Override
            public boolean onQueryTextChange(String newText) {
                infoAdapter.getFilter().filter(newText);

                //             if(newText.isEmpty()){
//                    btAddContact.setVisibility(View.VISIBLE);
//                }else {
//                    fabAddContact.setVisibility(View.INVISIBLE);
//                }
                return false;
            }
        });


        return true;
    }




    @Override
    public void onClickListener(int pos, Info info) {

    }

    @Override
    public void onEditListener(int pos, Info info) {

    }

    @Override
    public void onDeleteListener(int pos, Info info) {

    }

    @Override
    public boolean onCreateOptionMenu(Menu menu) {
        return false;
    }
}
