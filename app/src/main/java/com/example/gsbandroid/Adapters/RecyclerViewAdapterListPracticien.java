package com.example.gsbandroid.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gsbandroid.Models.Practicien;
import com.example.gsbandroid.Models.Visiteur;
import com.example.gsbandroid.R;

import java.util.List;

public class RecyclerViewAdapterListPracticien extends RecyclerView.Adapter<RecyclerViewAdapterListPracticien.RecyclerViewHolder> {
    private List<Practicien> dataModelList;
    public RecyclerViewAdapterListPracticien(List<Practicien> dataModelList){ this.dataModelList = dataModelList;}
    @NonNull
    @Override
    public RecyclerViewAdapterListPracticien.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_accueil_rdv1, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterListPracticien.RecyclerViewHolder
    holder,int position){
        holder.PracName.setText(String.valueOf(dataModelList.get(position).getNom().toUpperCase()));
    }


    @Override
    public int getItemCount () {
        return dataModelList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView PracName;

//        ImageView img_temps;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            PracName = itemView.findViewById(R.id.RvPracticien);

//            img_temps = itemView.findViewById(R.id.text_temp);
        }
    }
}

