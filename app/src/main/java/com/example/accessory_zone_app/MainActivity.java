
package com.example.accessory_zone_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView btnAdd;
    RecyclerView gridRecycler;
    MyAdapter adapter;
    DBHelper DB;
    String ProductName,Price,Decprition;
    static List<rowModel> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        gridRecycler = findViewById(R.id.gridRecycler);
        gridRecycler.setLayoutManager(new GridLayoutManager(MainActivity.this,2 ));
        adapter = new MyAdapter(this,arrayList);
        gridRecycler.setAdapter(adapter);
        DBHelper DB = new DBHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivity(intent);
            }
        });
        displaydata();
    }

    private void displaydata() {
        Cursor res = DB.getdata();
        if (res.getCount()==0){
            Toast.makeText(MainActivity.this,"No Entery Exists", Toast.LENGTH_SHORT).show();
            while (res.moveToNext()){
                arrayList.add(new rowModel(res.getString(1),res.getString(2),res.getString(3)));
            }
            Toast.makeText(this, ""+arrayList.size(), Toast.LENGTH_SHORT).show();
        }
    }
}