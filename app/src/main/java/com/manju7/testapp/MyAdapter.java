package com.manju7.testapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<CarDetails> caritemsList;
    private Context context;

    public MyAdapter(List<CarDetails> itemsList, Context context) {
        this.caritemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_items,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        CarDetails items = caritemsList.get(position);

        holder.name.setText("Name - " +items.getName());
        holder.vin.setText("Vin - "+items.getVin());
        holder.interior.setText("Interior - "+items.getInterior());
        holder.fuel.setText("Fuel - "+items.getFuel());
        holder.exterior.setText("Exterior - "+items.getExterior());
        holder.engineType.setText("Engine Type - "+items.getEngineType());
        holder.coordinates.setText("Coordinates - "+items.getCoordinates());
        holder.address.setText("Address - "+items.getAddress());

        holder.cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,MapsActivity.class);

                intent.putExtra("name",caritemsList.get(position).getName());
                intent.putExtra("coordinates",caritemsList.get(position).getCoordinates());


                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return caritemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView name , vin , interior ,fuel,exterior,engineType,coordinates,address;
        CardView cardView1;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            vin = (TextView) itemView.findViewById(R.id.vin);
            interior = (TextView) itemView.findViewById(R.id.interior);
            fuel = (TextView) itemView.findViewById(R.id.fuel);
            exterior = (TextView) itemView.findViewById(R.id.exterior);
            engineType = (TextView) itemView.findViewById(R.id.engineType);
            name = (TextView) itemView.findViewById(R.id.name);
            coordinates = (TextView) itemView.findViewById(R.id.coordinates);
            address = (TextView) itemView.findViewById(R.id.address);
            cardView1=(CardView)itemView.findViewById(R.id.cardview_id);
        }
    }
}
