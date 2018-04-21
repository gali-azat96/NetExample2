package com.npp.netexample2.weatherList;

import com.npp.netexample2.entity.WeatherListAnswer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Azat Galiullin.
 */

public class WeatherListPresenter {
    WeatherListModel model;
    WeatherListActivity activity;

    public WeatherListPresenter(WeatherListActivity activity) {
        this.activity = activity;
        model = new WeatherListModel();
    }

    public void getListWeather(String city){
        model.getWeatherList(city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherListAnswer>() {
                    @Override
                    public void accept(WeatherListAnswer weatherListAnswer) throws Exception {
                        activity.updateList(weatherListAnswer.getWeatherList());
                    }
                });
    }


}
