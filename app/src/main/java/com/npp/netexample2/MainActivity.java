package com.npp.netexample2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.npp.netexample2.entity.WeatherAnswer;
import com.npp.netexample2.weatherList.WeatherListActivity;

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
//        presenter.getWeather(editText.getText().toString());
        Intent intent = new Intent(this, WeatherListActivity.class);
        intent.putExtra("city", editText.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }

    public void showTemp(Double temp) {
        textView.setText(temp + "");
    }
}
