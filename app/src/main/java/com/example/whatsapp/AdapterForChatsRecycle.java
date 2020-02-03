package com.example.whatsapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterForChatsRecycle extends RecyclerView.Adapter<AdapterForChatsRecycle.NewViewHolder> {
    private ArrayList<ChatsView> arrayLis;
   private OnClickViewItemAdapter onClickViewItemAdapter;
    public AdapterForChatsRecycle(ArrayList<ChatsView> arrayLis,OnClickViewItemAdapter onClickViewItemAdapter) {
        this.arrayLis = arrayLis;
        this.onClickViewItemAdapter=onClickViewItemAdapter;
    }


    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.chatsview,parent,false);
        return new NewViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
    ChatsView view=arrayLis.get(position);
    holder.im_person.setImageResource(arrayLis.get(position).getId());
    holder.tv_name.setText(arrayLis.get(position).getName());
    holder.tv_mess.setText(arrayLis.get(position).getMess());
    holder.tv_time.setText(arrayLis.get(position).getTime());

    holder.im_person.setTag(arrayLis.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return arrayLis.size();
    }

    public  class NewViewHolder extends RecyclerView.ViewHolder {
        ImageView im_person;
        TextView tv_name;
        TextView tv_mess;
        TextView tv_time;

        public NewViewHolder(final View itemView) {
            super(itemView);
            im_person = (ImageView) itemView.findViewById(R.id.im_person);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_mess = (TextView) itemView.findViewById(R.id.tv_mess);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);

            im_person.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id=(int)im_person.getTag();
                    onClickViewItemAdapter.onClickViewItem(id);
                    ;
                }
            });
        }
    }
}
