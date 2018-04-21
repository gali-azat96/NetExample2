package com.npp.netexample2.weatherList;

import com.google.gson.Gson;
import com.npp.netexample2.entity.WeatherListAnswer;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Azat Galiullin.
 */

public class WeatherListModel {

    public Observable<WeatherListAnswer> getWeatherList(final String city){
        return Observable.fromCallable(new Callable<String>() {

            @Override
            public String call() throws Exception {
                Request request = new Request.Builder()
                        .url("https://api.openweathermap.org/data/2.5/forecast?q=" +
                                city +"&appid=feb13a76462a1348fcacb20e91a6ab86")
                        .build();
                OkHttpClient client = new OkHttpClient();
                final Response response = client.newCall(request).execute();
                return response.body().string();
            }
        })
                .map(new Function<String, WeatherListAnswer>() {

                    @Override
                    public WeatherListAnswer apply(String s) throws Exception {
                        return new Gson().fromJson(s, WeatherListAnswer.class);
                    }
                });
    }

}
