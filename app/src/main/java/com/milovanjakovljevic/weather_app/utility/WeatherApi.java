package com.milovanjakovljevic.weather_app.utility;

import com.milovanjakovljevic.weather_app.response.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("/data/2.5/weather")
    Call<WeatherResponse> searchWeather(
            @Query("q") String city,
            @Query("appid") String key
    );



}
