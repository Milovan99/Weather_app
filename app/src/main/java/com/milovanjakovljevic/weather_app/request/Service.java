package com.milovanjakovljevic.weather_app.request;

import com.milovanjakovljevic.weather_app.utility.Credentials;
import com.milovanjakovljevic.weather_app.utility.WeatherApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    private static Retrofit.Builder retrofitBuilder=
            new Retrofit.Builder()
                    .baseUrl(Credentials.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit=retrofitBuilder.build();

    private static WeatherApi weatherApi = retrofit.create(WeatherApi.class);

    public static WeatherApi getWeatherApi(){
        return weatherApi;
    }
}
