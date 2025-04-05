package com.example.accessory_zone_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    List<rowModel> arrayList;
    DBHelper DB ;

    public MyAdapter(Context context, List<rowModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

       @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.row_view,parent,false);
    return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final rowModel dataPosition = arrayList.get(position);
        holder.ProductName.setText(dataPosition.getProductName());
        holder.Price.setText(dataPosition.getPrice());
        holder.ProductImage.setImageURI(dataPosition.getUri());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                arrayList.remove(position);
//                notifyItemRemoved(position);
                //DB = new DBHelper(this);

                Boolean deletedata = DB.deletedata(dataPosition.productName);
                if (deletedata == true){
                    Toast.makeText(context, "Entery deleted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "not deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetail.class);
                intent.putExtra("ProductName",dataPosition.productName);
                intent.putExtra("Price",dataPosition.Price);
                intent.putExtra("img",dataPosition.uri);
                intent.putExtra("des",dataPosition.Descripition);
                if (context instanceof MainActivity) {
                    ((MainActivity) context).startActivityForResult(intent,1);
                }



            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView delete;
        ImageView ProductImage;
        TextView ProductName;
        TextView Price;
        LinearLayout item;
      //  TextView Description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            delete = itemView.findViewById(R.id.delete);
            ProductImage = itemView.findViewById(R.id.ProductImage);
            ProductName = itemView.findViewById(R.id.productName);
            Price = itemView.findViewById(R.id.Price);
            item = itemView.findViewById(R.id.item);
           // Description = itemView.findViewById(R.id.Description);

        }
    }
    }
