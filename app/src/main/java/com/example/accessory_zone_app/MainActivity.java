
package com.example.accessory_zone_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView btnAdd;
    RecyclerView gridRecycler;
    MyAdapter adapter;
    static ArrayList<rowModel> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        gridRecycler = findViewById(R.id.gridRecycler);
        gridRecycler.setLayoutManager(new GridLayoutManager(MainActivity.this,2 ));
        adapter = new MyAdapter(this,arrayList);
        gridRecycler.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivity(intent);
            }
        });
        String a = getIntent().getStringExtra("a");
        if (a!=null){
        String ProductName = getIntent().getStringExtra("pName");
        String Price = getIntent().getStringExtra("Price");
        String Description = getIntent().getStringExtra("Description");
        Uri uri = getIntent().getParcelableExtra("img");
        rowModel newitem= new rowModel(ProductName,Price,Description,uri);
        arrayList.add(newitem);
        adapter.notifyItemInserted(arrayList.size()-1);
        }
    }
}