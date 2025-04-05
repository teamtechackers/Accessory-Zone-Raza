package com.example.accessory_zone_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddItem extends AppCompatActivity {
    ImageView back;
    ImageView addImage;
    EditText edtProduct,edtPrice,edtDescription;
    AppCompatButton save;
    Uri uri;
    DBHelper DB = new DBHelper(this);
    public static final String a = String.valueOf(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        back =findViewById(R.id.backArrow);
        addImage = findViewById(R.id.addImage);
        edtProduct = findViewById(R.id.edtProductName);
        edtPrice = findViewById(R.id.edtPrice);
        edtDescription = findViewById(R.id.Description);
        save = findViewById(R.id.btnSave);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddItem.this,MainActivity.class);
                startActivity(intent);
            }
        });

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,1);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ProductName = edtProduct.getText().toString();
                String Price = edtPrice.getText().toString();
                String Description = edtDescription.getText().toString();


                Boolean checkinsertdata = DB.insertuserdata(ProductName,Price,Description);
                if (checkinsertdata == true){
                    Toast.makeText(AddItem.this, "new Entery inserted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(AddItem.this, "not inserted", Toast.LENGTH_SHORT).show();
                }


                Intent intent = new Intent(AddItem.this, MainActivity.class);

                if (!ProductName.isEmpty()&&!Price.isEmpty()&&!Description.isEmpty()){
                intent.putExtra("pName",ProductName);
                intent.putExtra("Price",Price);
                intent.putExtra("Description",Description);
                intent.putExtra("img",uri);
                intent.putExtra("a",a);
                startActivity(intent);
                }
                else {
                    Toast.makeText(AddItem.this, "Please Fill all Fileds & Select an Image", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && data!=null){
            uri = data.getData();
            addImage.setImageURI(uri);
        }
    }
}