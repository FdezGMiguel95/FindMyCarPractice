package com.example.findmycarpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterParking extends RecyclerView.Adapter<AdapterParking.ViewHolder>{
    private ArrayList<Aparcamiento> sitios;
    public AdapterParking(ArrayList<Aparcamiento>sitios){
        this.sitios = sitios;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vParking = layoutInflater.inflate(R.layout.list_tem, parent, false);
        ViewHolder vHolder = new ViewHolder(vParking);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterParking.ViewHolder holder, int position) {
        final Aparcamiento a = sitios.get(position);
        holder.tvName.setText(sitios.get(position).getName());
        holder.tvLat.setText(String.valueOf(sitios.get(position).getaLat()));
        holder.tvLong.setText(String.valueOf(sitios.get(position).getaLong()));
    }

    @Override
    public int getItemCount() {
        return sitios.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName, tvLat, tvLong;
        public LinearLayout llCard;
        public ViewHolder(View itemView){
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.tvName);
            this.tvLat = (TextView) itemView.findViewById(R.id.tvLat);
            this.tvLong = (TextView) itemView.findViewById(R.id.tvLong);
            llCard = (LinearLayout) itemView.findViewById(R.id.llCard);
        }
    }
}
