package com.example.garrymehta.itmtrack;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class busesFragment extends Fragment {

    private static final String URL_DATA = "http://192.168.43.173/ITMtrackApi/api.php";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.buses_fragment, null);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        listItems = new ArrayList<>();


        loadRecyclerViewData();

    }

    private void loadRecyclerViewData(){
        final ProgressDialog dialog = ProgressDialog.show(getActivity(),"Loading...", "Please wait...", true);
        dialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                try {
                    JSONArray businfo=new JSONArray(response);
                    for (int i=0; i<businfo.length();i++){
                        JSONObject jsonObject=businfo.getJSONObject(i);
                        ListItem item =new ListItem(
                        jsonObject.getString("busnumber"),
                                jsonObject.getString("busregnumber"),
                                jsonObject.getString("drivername")
                        );


                        listItems.add(item);
                    }
                    adapter=new MyBusAdapter(listItems,getActivity().getApplicationContext());
                    recyclerView.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Toast.makeText(getActivity(), error.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue requestQueue =Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
}

