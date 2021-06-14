package com.example.projeh;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
public class Cadapter extends RecyclerView.Adapter<Cadapter.CatgorViewHolder>
{

    ArrayList<Cmodel> cmodels;
    Context context;

    public Cadapter(dashbord context, ArrayList<Cmodel>cmodels)
    {
     //   this.context=context;
        this.cmodels=cmodels;

    }

    public <onOpttionItemSelete> Cadapter(doashbord<onOpttionItemSelete> onOpttionItemSeletedoashbord, ArrayList<Cmodel> categories){
    }

    @NonNull
    @Override
    public CatgorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view=LayoutInflater.from(context).inflate(R.layout.catagory,null);
        return new CatgorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatgorViewHolder holder, int position){
Cmodel model= cmodels.get(position);
holder.name.setText(model.getName());
Glide.with(context).load(model.getLogo()).into(holder.logo);

    }

    @Override
    public int getItemCount(){
        return cmodels.size();
    }

    public class CatgorViewHolder extends RecyclerView.ViewHolder {
        ImageView logo;
        TextView name,price;
        public CatgorViewHolder(@NonNull View itemView){
            super(itemView);
            logo =itemView.findViewById(R.id.logo);
            name =itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
        }
    }
}
