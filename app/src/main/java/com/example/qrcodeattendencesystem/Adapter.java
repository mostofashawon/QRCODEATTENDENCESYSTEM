package com.example.qrcodeattendencesystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHoler>{


    private Context context;
    private List<Model> list;

    public Adapter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dummy,parent,false);

        return new MyViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {

        Model model = list.get(position);

        holder.DateTitle.setText("Date :");
        holder.DateText.setText(model.getDate());
        holder.InTimeTitle.setText("InTime :");
        holder.IntimeText.setText(model.getIntime());
        holder.OutTimeTitle.setText("OutTime :");
        holder.OutTimeText.setText(model.getOuttime());
        holder.OverTitle.setText("OverTime :");
        holder.OverText.setText(model.getOverTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHoler extends RecyclerView.ViewHolder {

        TextView DateTitle,DateText,
                InTimeTitle,IntimeText,
                OutTimeTitle,OutTimeText,
                OverTitle,OverText;


        public MyViewHoler(@NonNull View itemView) {
            super(itemView);


            DateTitle = itemView.findViewById(R.id.DummydateTitile);
            DateText = itemView.findViewById(R.id.DummydateText);
            InTimeTitle = itemView.findViewById(R.id.DummyIntimeTitile);
            IntimeText = itemView.findViewById(R.id.DummyIntimeText);
            OutTimeTitle = itemView.findViewById(R.id.DummyOutTitile);
            OutTimeText = itemView.findViewById(R.id.DummyOutText);
            OverTitle = itemView.findViewById(R.id.DummyOverTitile);
            OverText = itemView.findViewById(R.id.DummyOverText);
        }
    }
}
