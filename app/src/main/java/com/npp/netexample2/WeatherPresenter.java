package com.npp.netexample2;

import com.npp.netexample2.entity.Weather;
import com.npp.netexample2.entity.WeatherAnswer;

/**
 * @author Azat Galiullin.
 */

public class WeatherPresenter {
    private MainActivity activity;
    private WeatherModel model;

    public WeatherPresenter(MainActivity activity) {
        this.activity = activity;
        this.model = new WeatherModel(this);
    }

    public void getWeather(String city){
        model.getCurrentWeather(city);
    }

    public void onWeatherSubmitted(WeatherAnswer weatherAnswer) {
        activity.showTemp(weatherAnswer.getMain().getTemp());
    }
}
