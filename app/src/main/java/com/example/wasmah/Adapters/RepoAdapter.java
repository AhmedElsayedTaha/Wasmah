package com.example.wasmah.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wasmah.Models.OurBaseClass;
import com.example.wasmah.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RepoAdapter extends PagedListAdapter<OurBaseClass,RepoAdapter.MyViewHolder> {
    private Context context;
    public RepoAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.repos_item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OurBaseClass ourBaseClass = getItem(position);
        if(ourBaseClass!=null) {
            holder.nameTv.setText(ourBaseClass.getName());
            holder.privateTv.setText(ourBaseClass.getPrivate().toString());
            holder.descTv.setText(ourBaseClass.getDescription());
        }
    }

    //For determine if two list of ourBaseClass is same or not
     private static DiffUtil.ItemCallback<OurBaseClass> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<OurBaseClass>() {
        @Override
        public boolean areItemsTheSame(@NonNull OurBaseClass oldItem, @NonNull OurBaseClass newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull OurBaseClass oldItem, @NonNull OurBaseClass newItem) {
            return true;
        }
    };


     class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameTv,descTv,privateTv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameDesc);
            descTv = itemView.findViewById(R.id.descDesc);
            privateTv = itemView.findViewById(R.id.privateDesc);
        }
    }
}
