package com.manju7.testapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

public class CarsDetailsPage extends AppCompatActivity {

    private static final String URL="https://s3-us-west-2.amazonaws.com/wunderbucket/locations.json";


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<CarDetails> caritemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_details_page);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        caritemsList=new ArrayList<>();

        loadData();
    }

    private void loadData() {


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data ....");
        progressDialog.show();


        StringRequest stringRequest = new StringRequest(Request.Method.GET
                , URL
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();

                try {


                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("placemarks");

                    for (int i=0; i<array.length(); i++){

                        JSONObject object = array.getJSONObject(i);
                        CarDetails items = new CarDetails(


                                        object.getString("address"),
                                        object.getString("coordinates"),
                                        object.getString("engineType"),
                                        object.getString("exterior"),
                                        object.getString("fuel"),
                                        object.getString("interior"),
                                        object.getString("name"),
                                        object.getString("vin")


                        );

                        caritemsList.add(items);

                    }

                    adapter = new MyAdapter(caritemsList,getApplicationContext());
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
