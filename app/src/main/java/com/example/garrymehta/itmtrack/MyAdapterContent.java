package com.example.garrymehta.itmtrack;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class MyAdapterContent extends RecyclerView.Adapter<MyAdapterContent.ViewHolder>  {


      List<modelContent> modelContents;

        private Context context;



    public void updatelist(List<modelContent> modelContents){

        modelContents=new ArrayList<>();
        modelContents.addAll(modelContents);
        notifyDataSetChanged();

    }

    public MyAdapterContent(List<modelContent> modelContents, Context context) {
        this.modelContents = modelContents;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.content_stops_lists,viewGroup,false);

        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        modelContent modellist=modelContents.get(i);

        viewHolder.tv_content_stops.setText(modellist.getStop());


    }

    @Override
    public int getItemCount() {
        return  modelContents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public TextView tv_content_stops;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_content_stops=itemView.findViewById(R.id.tv_content_stops);
        }
    }




}

