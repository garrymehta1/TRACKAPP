package com.example.garrymehta.itmtrack;

import android.app.Activity;
import android.app.LauncherActivity.ListItem;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.PublicKey;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;
import static java.security.AccessController.getContext;

public class MyBusAdapter extends RecyclerView.Adapter<MyBusAdapter.ViewHolder> {
    DatabaseReference reff;
    String latitute;
    String longitute;

   private List<com.example.garrymehta.itmtrack.ListItem> listItems;
   private Context context;

    public MyBusAdapter(List<com.example.garrymehta.itmtrack.ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.bus_list_content, viewGroup, false);
        return new ViewHolder(v);



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        final com.example.garrymehta.itmtrack.ListItem listItem=listItems.get(i);
        viewHolder.busnumber.setText(listItem.getBusnumber());
        viewHolder.busregnumber.setText(listItem.getBusregnumber());
        viewHolder.busdriver.setText(listItem.getBusdrivername());
        viewHolder.button_locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                //Toast.makeText(context,"you click"+listItem.getBusnumber(),Toast.LENGTH_LONG).show();
                reff= FirebaseDatabase.getInstance().getReference().child("online_drivers").child("0000");
                reff.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                         latitute=dataSnapshot.child("lat").getValue().toString();
                        longitute=dataSnapshot.child("lng").getValue().toString();
                        Toast.makeText(context,"Bus Moving",Toast.LENGTH_SHORT).show();
                        Intent i;
                        i = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:"+latitute+longitute));

                        ((Activity) v.getContext()).finish();
                        ((Activity)v.getContext()).startActivity(i);




                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {



                    }


                });



            }
        });


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView busnumber;
        public TextView busregnumber;
        public TextView busdriver;
        public Button button_locate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            busnumber = itemView.findViewById(R.id.busnumber);
            busregnumber= itemView.findViewById(R.id.busregnumber);
            busdriver= itemView.findViewById(R.id.busdriver);
            button_locate= itemView.findViewById(R.id.button_locate);

        }
    }
}
