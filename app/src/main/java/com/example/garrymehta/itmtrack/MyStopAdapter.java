package com.example.garrymehta.itmtrack;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.garrymehta.itmtrack.R;
import com.example.garrymehta.itmtrack.StopsList;

import java.util.ArrayList;
import java.util.List;

public class MyStopAdapter extends RecyclerView.Adapter<MyStopAdapter.ViewHolder>  {


    private List<StopsList> stopsLists;

    Context context;

    public MyStopAdapter(List<StopsList> stopsLists, Context context) {
        this.stopsLists = stopsLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.stop_lists, viewGroup ,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        StopsList stopsList= stopsLists.get(i);

        viewHolder.tvstops.setText(stopsList.getStop());


    }

    @Override
    public int getItemCount() {
        return stopsLists.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvstops;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvstops = itemView.findViewById(R.id.tvstops);
        }
    }

}
