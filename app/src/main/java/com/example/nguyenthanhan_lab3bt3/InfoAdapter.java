package com.example.nguyenthanhan_lab3bt3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoVH> {

    ArrayList<Info> infos;
    Listener listener;

    public InfoAdapter(ArrayList<Info> infos, Listener listener) {
        this.infos = infos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public InfoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_row,parent,false);
        return new InfoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoVH holder, int position) {
        Info info = infos.get(position);
        holder.imgFlag.setImageResource(info.getImage());
        holder.txName.setText(info.getFname()+" "+info.getLname());
        holder.txPhone.setText(info.getPhone());
        holder.txFax.setText(info.getMail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemListener(info);
            }
        });
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    class InfoVH extends RecyclerView.ViewHolder{

        CircleImageView imgFlag;
        TextView txName,txPhone,txFax;
        public InfoVH(@NonNull View itemView){
            super(itemView);
            imgFlag=itemView.findViewById(R.id.imgFlag);
            txName=itemView.findViewById(R.id.txName);
            txPhone=itemView.findViewById(R.id.txPhone);
            txFax=itemView.findViewById(R.id.txFax);
        }
    }
    interface Listener{
        void onItemListener(Info info);
    }
}

