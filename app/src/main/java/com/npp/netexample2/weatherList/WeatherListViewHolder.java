package com.npp.netexample2.weatherList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.npp.netexample2.R;
import com.npp.netexample2.entity.WeatherList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Azat Galiullin.
 */

public class WeatherListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text)
    TextView textView;

    public WeatherListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(WeatherList weatherList) {
        textView.setText(weatherList.getMain().getTemp() + "");
    }
}
