package com.npp.netexample2;

import com.google.gson.Gson;
import com.npp.netexample2.WeatherPresenter;
import com.npp.netexample2.entity.WeatherAnswer;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Azat Galiullin.
 */

public class WeatherModel {



//    public WeatherAnswer getCurrentWeather(String city, WeatherListener listener) {
//        Request request = new Request.Builder()
//                .url("https://api.openweathermap.org/data/2.5/weather?q=" + city +"&appid=feb13a76462a1348fcacb20e91a6ab86")
//                .build();
//        OkHttpClient client = new OkHttpClient();
//        try {
//            final Response response = client.newCall(request).execute();
//            String s  = response.body().string();
//            final WeatherAnswer weatherAnswer = new Gson().fromJson(s, WeatherAnswer.class);
//            listener.onWeatherSubmitted(weatherAnswer);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static interface WeatherListener{
//        void onWeatherSubmitted(WeatherAnswer answer);
//    }


}
