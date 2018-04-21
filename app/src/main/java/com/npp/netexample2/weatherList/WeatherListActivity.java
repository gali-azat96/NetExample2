package com.npp.netexample2.weatherList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.npp.netexample2.R;
import com.npp.netexample2.entity.WeatherList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherListActivity extends AppCompatActivity {

    @BindView(R.id.weather_list)
    RecyclerView weatherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);
        ButterKnife.bind(this);
        String city = getIntent().getStringExtra("city");
        WeatherListPresenter presenter = new WeatherListPresenter(this);
        presenter.getListWeather(city);
    }

    public void updateList(List<WeatherList> weatherList1) {
        weatherList.setLayoutManager(new LinearLayoutManager(this));
        weatherList.setAdapter(new WeatherListAdapter(weatherList1));
    }
}
