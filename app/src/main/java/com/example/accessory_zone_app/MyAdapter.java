package com.example.accessory_zone_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    ArrayList<rowModel> arrayList;

    public MyAdapter(Context context, ArrayList<rowModel> arrayList) {
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
        holder.ProductName.setText(arrayList.get(position).productName);
        holder.Price.setText(arrayList.get(position).Price);
        holder.ProductImage.setImageURI(arrayList.get(position).uri);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.remove(position);
                notifyItemRemoved(position);
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
