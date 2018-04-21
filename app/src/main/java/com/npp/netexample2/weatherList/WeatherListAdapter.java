package com.npp.netexample2.weatherList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.npp.netexample2.R;
import com.npp.netexample2.entity.WeatherList;

import java.util.List;

/**
 * @author Azat Galiullin.
 */

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListViewHolder> {

    List<WeatherList> lists;

    public WeatherListAdapter(List<WeatherList> lists) {
        this.lists = lists;
    }

    @Override
    public WeatherListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_weather_list_item, parent, false);
        return new WeatherListViewHolder(view);
    }


    @Override
    public void onBindViewHolder(WeatherListViewHolder holder, int position) {
        holder.bind(lists.get(position));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}
