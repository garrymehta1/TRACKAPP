package com.example.garrymehta.itmtrack;

import android.Manifest;
import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import java.util.List;

import static android.support.v4.app.ActivityCompat.requestPermissions;
import static java.security.AccessController.getContext;

public class MyDriverAdapter extends RecyclerView.Adapter<MyDriverAdapter.ViewHolder> {

    private List<DriverListItem> driverListItems;
    private Context context;
    String drivernumber;

    public MyDriverAdapter(List<DriverListItem> driverListItems, Context context) {
        this.driverListItems = driverListItems;
        this.context = context;
    }

    private void call()
    {

        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        call.setData(Uri.parse("tel:" + drivernumber));
        context.startActivity(call);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.driver_list_content,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final DriverListItem driverListItem=driverListItems.get(i);
        viewHolder.drivername.setText(driverListItem.getDrivername());
        viewHolder.driverphone.setText(driverListItem.getDriverphone());
        viewHolder.call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"you Click"+driverListItem.getDriverphone(),Toast.LENGTH_LONG).show();
                    drivernumber=driverListItem.getDriverphone();
                call();


            }
        });





    }

    @Override
    public int getItemCount() {
        return driverListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView drivername;
        public TextView driverphone;
        public Button call_button;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            drivername=(TextView)itemView.findViewById(R.id.drivername);
            driverphone=(TextView)itemView.findViewById(R.id.driverphone);
            call_button=(Button)itemView.findViewById(R.id.call_button);
        }
    }


}
