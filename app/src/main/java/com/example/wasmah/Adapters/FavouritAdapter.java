package com.example.wasmah.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wasmah.FavouritesActivity;
import com.example.wasmah.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavouritAdapter extends RecyclerView.Adapter<FavouritAdapter.MyViewHolder> {

    private List<String> favList;
    private Context context;
    public FavouritAdapter(List<String> favLists, Context context){
        this.favList=favLists;
        this.context=context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favourit_item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.faveTv.setText(favList.get(position));
    }

    @Override
    public int getItemCount() {
        return favList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView faveTv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            faveTv = itemView.findViewById(R.id.favName);
        }
    }
}
