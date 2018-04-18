package com.npp.netexample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.npp.netexample2.entity.WeatherAnswer;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.btn)
    Button button;
    @BindView(R.id.temp)
    TextView textView;

    WeatherPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onClick(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String city = editText.getText().toString();
                Request request = new Request.Builder()
                        .url("https://api.openweathermap.org/data/2.5/weather?q=" + city +"&appid=feb13a76462a1348fcacb20e91a6ab86")
                        .build();
                OkHttpClient client = new OkHttpClient();
                try {
                    final Response response = client.newCall(request).execute();
                    String s  = response.body().string();
                    final WeatherAnswer weatherAnswer = new Gson().fromJson(s, WeatherAnswer.class);
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(weatherAnswer.getMain().getTemp() + " ");
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }
}
