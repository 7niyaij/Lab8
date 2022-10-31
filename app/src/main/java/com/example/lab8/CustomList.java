package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }
    /**
     * this adds a city object to the list
     *for the first phase it will be empty
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * this checks if a city is inside the list
     * @param city
     * @return return true if city exist in list, otherwise return false
     */
    public boolean hasCity(City city) {
        Boolean hasCity = false;
        for (int i = 0; i < cities.size(); i++) {
            if (city.getCityName() == cities.get(i).getCityName()) {
                if (city.getProvinceName() == cities.get(i).getProvinceName()) {
                    hasCity = true;
                }
            }
        }
        return hasCity;
    }

    /**
     * This method delete the given city in our list {@link ArrayList<City> #cities}.
     * @param city
     *      This is a candidate city to delete which is of type {@link City}
     * @throws IllegalArgumentException
     */
    public void deleteCity(City city) {
        if (!hasCity(city)) {
            throw new IllegalArgumentException();
        }
        int index = -1;
        for (int i = 0; i < cities.size(); i++) {
            if (city.getCityName() == cities.get(i).getCityName()) {
                index = i;
            }
        }
        cities.remove(cities.get(index));
    }

    /**
     * This function returns how many cities are in the list {@link ArrayList<City> #cities}.
     * @return
     *      A {@link Integer} indicating how many cities are in the list
     */
    public int countCities() {
        return cities.size();
    }
}
