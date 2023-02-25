package com.milovanjakovljevic.weather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.milovanjakovljevic.weather_app.request.Service;
import com.milovanjakovljevic.weather_app.response.WeatherResponse;
import com.milovanjakovljevic.weather_app.utility.Credentials;
import com.milovanjakovljevic.weather_app.utility.WeatherApi;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetRetrofitResponse();
            }
        });
    }

    private void GetRetrofitResponse() {
        WeatherApi weatherApi= Service.getWeatherApi();
        Call<WeatherResponse>  responseCall = weatherApi.searchWeather("Belgrade", "9cb677dafaaa9538cd395fd6b110ebec");

        responseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if(response.code()==200){
                    Log.v("Tag","Response  "+ response.body().toString());
                    Toast.makeText(getApplicationContext(),response.body().getWeather().getTemp().toString(),Toast.LENGTH_LONG).show();
                }else{
                    try {
                        Log.v("Tag","Error" + response.errorBody().string());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

            }
        });
    }
}