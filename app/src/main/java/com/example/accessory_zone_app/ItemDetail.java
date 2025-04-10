package com.example.accessory_zone_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetail extends AppCompatActivity {
    TextView ProductName,Price,Description1;
    ImageView productImg,back;
    AppCompatButton addToBag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        ProductName = findViewById(R.id.ProductName);
        Price = findViewById(R.id.Price);
        Description1 = findViewById(R.id.txtDescription);
        productImg = findViewById(R.id.img);
        back = findViewById(R.id.back);
        addToBag = findViewById(R.id.btnAddToBag);

        String productName = getIntent().getStringExtra("ProductName");
        String Price1 = getIntent().getStringExtra("Price");
        String Description = getIntent().getStringExtra("des");
        Uri uri= getIntent().getParcelableExtra("img");

        ProductName.setText(productName);
        Price.setText(Price1);
        Description1.setText(Description);
        productImg.setImageURI(uri);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemDetail.this, MainActivity.class);
                startActivity(intent);
            }
        });
        addToBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemDetail.this,OderItem.class);
                String productName = ProductName.getText().toString();
                String price = Price.getText().toString();
                intent.putExtra("productName",productName);
                intent.putExtra("price",price);
                intent.putExtra("img",uri);
                startActivity(intent);

            }
        });




    }
}