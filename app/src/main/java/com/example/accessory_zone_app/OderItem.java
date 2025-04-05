package com.example.accessory_zone_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OderItem extends AppCompatActivity {
    ImageView productImg;
    TextView productName,price,totalPrice;
    AppCompatButton btnCheckOut;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder_item);
        productImg = findViewById(R.id.img);
        productName = findViewById(R.id.txtProductName);
        price = findViewById(R.id.txtPrice);
        totalPrice = findViewById(R.id.totalPrice);
        btnCheckOut = findViewById(R.id.btnCheckOut);
        back = findViewById(R.id.back);

        String productname = getIntent().getStringExtra("productName");
        String Price = getIntent().getStringExtra("price");
        Uri uri = getIntent().getParcelableExtra("img");
        productName.setText(productname);
        price.setText(Price);
        totalPrice.setText(Price);
        productImg.setImageURI(uri);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OderItem.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OderItem.this, "Task Completed", Toast.LENGTH_SHORT).show();
            }
        });




    }
}