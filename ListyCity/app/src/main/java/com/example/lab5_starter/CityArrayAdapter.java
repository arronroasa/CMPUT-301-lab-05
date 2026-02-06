package com.example.lab5_starter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CityArrayAdapter extends RecyclerView.Adapter<CityArrayAdapter.CityViewHolder> {

    // Define the interface for click handling
    public interface OnCityClickListener {
        void onCityClick(City city);
    }

    private final ArrayList<City> cities;
    private final Context context;
    private final OnCityClickListener listener;

    // Updated constructor to include the listener
    public CityArrayAdapter(Context context, ArrayList<City> cities, OnCityClickListener listener){
        this.cities = cities;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_city, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        City city = cities.get(position);
        holder.cityName.setText(city.getName());
        holder.cityProvince.setText(city.getProvince());

        holder.itemView.setOnClickListener(v -> listener.onCityClick(city));
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder {
        TextView cityName;
        TextView cityProvince;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.textCityName);
            cityProvince = itemView.findViewById(R.id.textCityProvince);
        }
    }

    public City getItem(Object city) {
        return (City) city;
    }
}