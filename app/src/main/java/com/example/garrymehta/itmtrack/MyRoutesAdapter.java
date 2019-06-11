package com.example.garrymehta.itmtrack;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static android.media.CamcorderProfile.get;

public class MyRoutesAdapter extends RecyclerView.Adapter<MyRoutesAdapter.ViewHolder> {


    private List<ModelRoutes> modelRoutes;
    private Context context;

    public MyRoutesAdapter(List<ModelRoutes> modelRoutes, Context context) {
        this.modelRoutes = modelRoutes;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.route_list_content,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ModelRoutes modelRoute=modelRoutes.get(i);
        viewHolder.tv_route_bus.setText(modelRoute.getRoutebusnumber());
        viewHolder.tv_routes_stop.setText(modelRoute.getRouteStops());



    }

    @Override
    public int getItemCount() {
        return modelRoutes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_route_bus;
        public TextView tv_routes_stop;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            tv_route_bus=(TextView)itemView.findViewById(R.id.tv_route_bus);
            tv_routes_stop=(TextView)itemView.findViewById(R.id.tv_routes_stop);
        }
    }
}
