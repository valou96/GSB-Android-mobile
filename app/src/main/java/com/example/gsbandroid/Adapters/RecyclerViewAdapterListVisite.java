package com.example.gsbandroid.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gsbandroid.Models.Visite;
import com.example.gsbandroid.R;

import java.util.ArrayList;

public class RecyclerViewAdapterListVisite extends RecyclerView.Adapter<RecyclerViewAdapterListVisite.RecyclerViewHolder> {
    private ArrayList<Visite> dataModelList;

    public RecyclerViewAdapterListVisite(ArrayList<Visite> dataModelList){ this.dataModelList = dataModelList;}
    @NonNull
    @Override
    public RecyclerViewAdapterListVisite.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.textview_recyclerview_visites, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterListVisite.RecyclerViewHolder
                                         holder,int position){
        holder.visite.setText(String.valueOf(dataModelList.get(position).getCompteRendu()));
    }


    @Override
    public int getItemCount () {
        return dataModelList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView visite;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            visite = itemView.findViewById(R.id.textView_RecyclerView_visites);
        }
    }
}

