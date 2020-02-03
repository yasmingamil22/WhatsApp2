package com.example.whatsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterForCallRecycle extends RecyclerView.Adapter<AdapterForCallRecycle.NewViewHolder> {
ArrayList<CallView> arrayList;

    public AdapterForCallRecycle(ArrayList<CallView> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.callsview,parent,false);
            return new AdapterForCallRecycle.NewViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        CallView view=arrayList.get(position);
        holder.im_call.setImageResource(arrayList.get(position).getIm_call());
        holder.tv_call.setText(arrayList.get(position).getTv_call());
        holder.call.setImageResource(R.drawable.ic_call_black_24dp);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class NewViewHolder extends RecyclerView.ViewHolder {
        ImageView im_call;
        TextView tv_call;
        ImageView call;

        public NewViewHolder(View itemView) {
            super(itemView);
            im_call = (ImageView) itemView.findViewById(R.id.im_call);
            tv_call = (TextView) itemView.findViewById(R.id.tv_call);
            call=itemView.findViewById(R.id.call);

        }
    }
}
