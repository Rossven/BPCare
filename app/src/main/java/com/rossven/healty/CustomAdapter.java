package com.rossven.healty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private Context context;
    private ArrayList id, name, dia, sys, date;

    CustomAdapter(Context context, ArrayList id, ArrayList name, ArrayList dia, ArrayList sys, ArrayList date){

        this.context=context;
        this.id=id;
        this.name=name;
        this.dia=dia;
        this.sys=sys;
        this.date=date;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.id_txt.setText(String.valueOf(id.get(position)));
        holder.dia_txt.setText(String.valueOf(dia.get(position)));
        holder.sys_txt.setText(String.valueOf(sys.get(position)));
        holder.date_txt.setText(String.valueOf(date.get(position)));


    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_txt,dia_txt, sys_txt, date_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id_txt = itemView.findViewById(R.id.inf_id);
            dia_txt = itemView.findViewById(R.id.inf_dia);
            sys_txt = itemView.findViewById(R.id.inf_sys);
            date_txt = itemView.findViewById(R.id.inf_date);


        }
    }
}
